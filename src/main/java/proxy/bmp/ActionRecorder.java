package proxy.bmp;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.home.training.constant.FilesSettingsConstants;
import com.home.training.constant.SystemConstants;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;

public class ActionRecorder {
    private static final Logger LOG = LogManager.getLogger("PROXY");
    private boolean isProxyLogEnabled;
    private BrowserMobProxy proxy;
    private String actionName;
    private Har har;

    public ActionRecorder() {
        proxy = ProxyHandler.INSTANCE.getProxy();
        isProxyLogEnabled = Boolean.parseBoolean(System.getProperty(SystemConstants.SYS_PROP_PROXY_LOG));
    }

    public ActionRecorder startRecord(String actionName) {
        this.actionName = actionName;
        if (isProxyLogEnabled) {
            LOG.debug("     === Start '" + actionName + "'");
        }
        har = null;
        proxy.newHar();
        return this;
    }

    public ActionRecorder stopRecord() {
        har = ProxyHandler.INSTANCE.getProxy().endHar();
        if (isProxyLogEnabled) {
            List<HarEntry> recordedLog = har.getLog().getEntries();
            for (HarEntry harEntry : recordedLog) {
                LOG.debug(harEntry.getRequest().getMethod() + ": "
                        + harEntry.getRequest().getUrl() + " > "
                        + harEntry.getResponse().getStatus());
            }
            LOG.debug("     === Stop '" + actionName + "'\n");
        }
        return this;
    }

    public Har getHarFile() {
        if (null == har) {
            throw new IllegalStateException("Perform stopRecord() method after you start record first!");
        }
        return har;
    }

    public ActionRecorder saveHarFile() {
        DateTimeFormatter dtf = DateTimeFormatter
                .ofPattern(FilesSettingsConstants.HAR_FORMAT_PATTERN);
        File harDirectory = new File(String.valueOf(FilesSettingsConstants.HAR_DIR));
        if (!harDirectory.exists()) {
            harDirectory.mkdir();
        }
        File harFile = new File(harDirectory,
                actionName + dtf.format(LocalDateTime.now()) + ".har");
        try {
            if (harFile.createNewFile()) {
                har.writeTo(harFile);
                LOG.info("Har file saved: " + harFile.getAbsolutePath());
            }
        } catch (IOException e) {
            LOG.error("Error during write HAR file: ".concat(e.getMessage()));
        }
        return this;
    }
}
