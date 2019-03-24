package proxy;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.home.training.ui.constant.FilesSettingsConstants;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;

public class ActionRecorder {
    private static final Logger LOG = LogManager.getLogger("PROXY");
    private BrowserMobProxy proxy;
    private String actionName;
    private Har har;

    public ActionRecorder() {
        proxy = ProxyHandler.INSTANCE.getProxy();
    }

    public ActionRecorder startRecord(String actionName) {
        this.actionName = actionName;
        LOG.debug("     === Start '" + actionName + "'");
        har = null;
        proxy.newHar();
        return this;
        // enable more detailed HAR capture, if desired (see CaptureType for the
        // complete list)
        // proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT,
        // CaptureType.RESPONSE_CONTENT);
    }

    public ActionRecorder stopRecord() {
        har = ProxyHandler.INSTANCE.getProxy().endHar();
        List<HarEntry> recordedLog = har.getLog().getEntries();
        for (HarEntry harEntry : recordedLog) {
            LOG.debug(harEntry.getRequest().getMethod() + ": "
                    + harEntry.getRequest().getUrl() + " > "
                    + harEntry.getResponse().getStatus());
        }
        LOG.debug("     === Stop '" + actionName + "'\n");
        return this;
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
            }
        } catch (IOException e) {
            LOG.error("Error during write HAR file: ".concat(e.getMessage()));
        }
        return this;
    }
}
