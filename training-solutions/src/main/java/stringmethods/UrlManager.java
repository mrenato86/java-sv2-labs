package stringmethods;

public class UrlManager {

    private String protocol;
    private Integer port;
    private String host;
    private String path;
    private String query;

    public UrlManager(String url) {
        this.protocol = getProtocolFromUrl(url);
        this.host = getHostFromUrl(url);
        this.port = getPortFromUrl(url);
        this.path = getPathFromUrl(url);
        this.query = getQueryFromUrl(url);
    }

    private String getProtocolFromUrl(String url) {
        return url.substring(0, url.indexOf("://")).toLowerCase();
    }

    private String getHostFromUrl(String url) {
        int startIndex = url.indexOf("://") + 3;
        int endIndex = url.indexOf(':', startIndex);
        if (endIndex == -1) {
            endIndex = url.indexOf('/', startIndex);
            if (endIndex == -1) {
                return url.substring(startIndex).toLowerCase();
            }
        }
        return url.substring(startIndex, endIndex).toLowerCase();
    }

    private Integer getPortFromUrl(String url) {
        int startIndex = url.indexOf(':', url.indexOf("://") + 3);
        if (startIndex == -1) {
            return null;
        }
        int endIndex = url.indexOf('/', startIndex);
        if (endIndex == -1) {
            return Integer.parseInt(url.substring(++startIndex));
        }
        return Integer.parseInt(url.substring(++startIndex, endIndex));
    }

    private String getPathFromUrl(String url) {
        int startIndex = url.indexOf('/', url.indexOf("://") + 3);
        if (startIndex == -1) {
            return "";
        }
        int endIndex = url.indexOf('?');
        if (endIndex == -1) {
            return url.substring(++startIndex);
        }
        return url.substring(++startIndex, endIndex);
    }

    private String getQueryFromUrl(String url) {
        int startIndex = url.indexOf('?');
        if (startIndex == -1) {
            return "";
        }
        return url.substring(++startIndex);
    }

    public boolean hasProperty(String key) {
        return query.startsWith(key + "=") || query.contains("&" + key + "=");
    }

    public String getProperty(String key) {
        String[] properties = query.split("&");
        for (String property : properties) {
            String[] keyValuePair = property.split("=");
            if (keyValuePair[0].equals(key)) {
                return keyValuePair[1];
            }
        }
        return null;
    }

    public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }


    public static void main(String[] args) {
        String url = "HTTPS://EarthQuake.USgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";
        UrlManager urlManager = new UrlManager(url);
        System.out.println(url);
        System.out.println("Protocol: " + urlManager.getProtocol());
        System.out.println("Host:" + urlManager.getHost());
        System.out.println("Port: " + urlManager.getPort());
        System.out.println("Path:" + urlManager.getPath());

        String urlWithPortAtEnd = "HTTPS://EarthQuake.USgs.gov:80";
        urlManager = new UrlManager(urlWithPortAtEnd);
        System.out.println("\n" + urlWithPortAtEnd);
        System.out.println("Protocol: " + urlManager.getProtocol());
        System.out.println("Host:" + urlManager.getHost());
        System.out.println("Port: " + urlManager.getPort());
        System.out.println("Path:" + urlManager.getPath());

        String urlWithPort = "HTTPS://EarthQuake.USgs.gov:80/query?a=4";
        urlManager = new UrlManager(urlWithPort);
        System.out.println("\n" + urlWithPort);
        System.out.println("Protocol: " + urlManager.getProtocol());
        System.out.println("Host:" + urlManager.getHost());
        System.out.println("Port: " + urlManager.getPort());
        System.out.println("Path:" + urlManager.getPath());

        String urlWithProperty = "HTTPS://EarthQuake.USgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";
        urlManager = new UrlManager(urlWithProperty);
        System.out.println("\n" + urlWithProperty);
        System.out.println("Protocol: " + urlManager.getProtocol());
        System.out.println("Host:" + urlManager.getHost());
        System.out.println("Port: " + urlManager.getPort());
        System.out.println("Path:" + urlManager.getPath());

        System.out.println("has format: " + urlManager.hasProperty("format"));
        System.out.println(urlManager.getProperty("format"));
        System.out.println("has place: " + urlManager.hasProperty("place"));
        System.out.println(urlManager.getProperty("place"));
        System.out.println("has time: " + urlManager.hasProperty("time"));
        System.out.println(urlManager.getProperty("time"));
        System.out.println("has endtime: " + urlManager.hasProperty("endtime"));
        System.out.println(urlManager.getProperty("endtime"));
    }

}
