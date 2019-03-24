package proxy;

import org.openqa.selenium.Proxy;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;

public enum ProxyHandler {
    INSTANCE;
    BrowserMobProxy proxy;

    public BrowserMobProxy getProxy() {
        if (null == proxy) {
            proxy = new BrowserMobProxyServer();
            proxy.start(0);
        }
        return proxy;
    }

    public Proxy getSeleniumProxy() {
        return ClientUtil.createSeleniumProxy(getProxy());
    }

}
