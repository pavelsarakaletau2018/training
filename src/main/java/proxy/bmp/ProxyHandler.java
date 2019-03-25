package proxy.bmp;

import org.openqa.selenium.Proxy;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.filters.ResponseFilter;
import proxy.bmp.filter.SimpleResponseFilter;

public enum ProxyHandler {
    INSTANCE;
    BrowserMobProxy proxy;

    public BrowserMobProxy getProxy() {
        if (null == proxy) {
            proxy = new BrowserMobProxyServer();
            proxy.addResponseFilter(new SimpleResponseFilter());
            proxy.start(0);
        }
        return proxy;
    }

    public Proxy getSeleniumProxy() {
        return ClientUtil.createSeleniumProxy(getProxy());
    }
    
    public void addResponseFilter (ResponseFilter filter) {
        proxy.addResponseFilter(filter);
    }

}
