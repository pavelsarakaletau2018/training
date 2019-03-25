package proxy.bmp.filter;

import io.netty.handler.codec.http.HttpResponse;
import net.lightbody.bmp.filters.ResponseFilter;
import net.lightbody.bmp.util.HttpMessageContents;
import net.lightbody.bmp.util.HttpMessageInfo;

public class SimpleResponseFilter implements ResponseFilter{

    @Override
    public void filterResponse(HttpResponse response, HttpMessageContents contents, HttpMessageInfo messageInfo) {
        contents.setTextContents("<html>\n" + 
                "<body>\n" + 
                "    <h1>Demo html content</h1>\n" + 
                "</body>\n" + 
                "</html>");
    }

}
