public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        if(numRows==0) return res;
        for(int i=0;i<numRows;i++){
            List<Integer> solu=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i)
                    solu.add(1);
                else{
                    solu.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
            }
            res.add(solu);
        }
        return res;
    }
}