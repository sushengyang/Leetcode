public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String str:strs){
            sb.append(String.valueOf(str.length())+"#");
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res=new ArrayList<>();
        int start=0;
        while(start<s.length()){
            int index=s.indexOf("#",start);
            int size=Integer.parseInt(s.substring(start,index));
            res.add(s.substring(index+1,index+size+1));
            start=index+size+1;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));