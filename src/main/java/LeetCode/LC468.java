package LeetCode;

public class LC468 {
    public String validIPAddress(String IP) {
        if(validIP4(IP)) return "IPv4";
        if(validIP6(IP)) return "IPv6";
        return "Neither";
    }
    public boolean validIP4(String ip){
        if(ip.length()<7) return false;
        int i;
        int nsect = 0;
        int start=0;
        String sect=null;
        for(i=0;i<ip.length();i++){
            char c= ip.charAt(i);
            if(!validIP4Char(c)) return false;
            if(c=='.'){
                nsect++;
                if(nsect>3) return false;
                sect = ip.substring(start,i);
                if(!validIP4Sect(sect)) return false;
                start=i+1;
            }
        }
        nsect++;
        if(nsect!=4) return false;
        if(start>=ip.length()) return false;
        sect=ip.substring(start,i);
        return validIP4Sect(sect);
    }
    public boolean validIP6(String ip){
        if(ip.length()<15) return false;
        int nsect = 0;
        int start=0;
        String sect=null;
        int i;
        for(i=0;i<ip.length();i++){
            char c= ip.charAt(i);
            if(!validIP6Char(c)) return false;
            if(c==':'){
                nsect++;
                if(nsect>7) return false;
                sect = ip.substring(start,i);
                if(!validIP6Sect(sect)) return false;
                start=i+1;
            }
        }
        nsect++;
        if(nsect!=8) return false;
        if(start>=ip.length()) return false;
        sect=ip.substring(start,i);
        return validIP6Sect(sect);
    }
    public boolean validIP6Sect(String sect){
        if(sect.length()<1 || sect.length()>4 ) return false;
        return true;
    }
    public boolean  validIP4Sect(String sect){
        if(sect.length()<1 || sect.length()>3) return false;
        if(sect.charAt(0)=='0' && sect.length()>1) return false;
        int n = Integer.valueOf(sect);
        return n<=255;
    }
    public boolean validIP4Char(char c){
        return (c>='0'&&c<='9') || c=='.';
    }
    public boolean validIP6Char(char c){
        return (c>='0'&&c<='9') || (c>='A'&& c<='E') || (c>='a' && c<='e') || c==':';
    }
    public static void main(String[] args){
        new LC468().validIP6("20EE:Fb8:85a3:0:0:8A2E:0370:7334");
    }
}
