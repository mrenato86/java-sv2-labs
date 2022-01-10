package nestedclasses.dns;

import java.util.ArrayList;
import java.util.List;

public class NameServer {

    private static class DnsEntry {
        private String hostName;

        private String hostIp;

        public DnsEntry(String hostName, String hostIp) {
            this.hostName = hostName;
            this.hostIp = hostIp;
        }
    }

    private final List<DnsEntry> dnsEntries = new ArrayList<>();

    public void addEntry(String hostName, String hostIp) {
        if (containsName(hostName) || containsIp(hostIp)) {
            throw new IllegalArgumentException("Already exists");
        }
        dnsEntries.add(new DnsEntry(hostName, hostIp));
    }

    public void removeEntryByName(String hostName) {
        DnsEntry dnsEntry = getEntryByName(hostName);
        if (dnsEntry != null) {
            dnsEntries.remove(dnsEntry);
        }
    }

    public void removeEntryByIp(String hostIp) {
        DnsEntry dnsEntry = getEntryByIp(hostIp);
        if (dnsEntry != null) {
            dnsEntries.remove(dnsEntry);
        }
    }

    public String getIpByName(String hostName) {
        DnsEntry dnsEntry = getEntryByName(hostName);
        if (dnsEntry == null) {
            throw new IllegalArgumentException("Element not found");
        }
        return dnsEntry.hostIp;
    }

    public String getNameByIp(String hostIp) {
        DnsEntry dnsEntry = getEntryByIp(hostIp);
        if (dnsEntry == null) {
            throw new IllegalArgumentException("Element not found");
        }
        return dnsEntry.hostName;
    }

    private DnsEntry getEntryByName(String hostName) {
        for (DnsEntry entry : dnsEntries) {
            if (entry.hostName.equals(hostName)) {
                return entry;
            }
        }
        return null;
    }

    private DnsEntry getEntryByIp(String hostIp) {
        for (DnsEntry entry : dnsEntries) {
            if (entry.hostIp.equals(hostIp)) {
                return entry;
            }
        }
        return null;
    }

    private boolean containsName(String hostName) {
        for (DnsEntry entry : dnsEntries) {
            if (entry.hostName.equals(hostName)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsIp(String hostIp) {
        for (DnsEntry entry : dnsEntries) {
            if (entry.hostIp.equals(hostIp)) {
                return true;
            }
        }
        return false;
    }

}
