package proxy.bmp.ulil;

import java.util.ArrayList;
import java.util.List;

import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.core.har.HarRequest;

public final class HarAnalyzer {
    private HarAnalyzer() {
    }

    public static List<HarRequest> getRequestsByUrl(Har har, String urlPattern) {
        List<HarRequest> harEntryList = new ArrayList<>();
        for (HarEntry entry : har.getLog().getEntries()) {
            if (entry.getRequest() != null) {
                HarRequest request = entry.getRequest();
                String requestUrl = entry.getRequest().getUrl();
                if (requestUrl.contains(urlPattern)) {
                    harEntryList.add(request);
                }
            }
        }
        return harEntryList;
    }

}
