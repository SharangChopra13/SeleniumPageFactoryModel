package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    // we can store values in data provider like this when we have pre-defined values like ate the time of sign-in
//    @DataProvider(name = "SignUpData")
//    public Object[][] getData() {
//        return new Object[][] {
//                {"scc116","scc"},
//                {"scc117","scc"},
//        };
//    }

    //When we have to create multiple users for testing purposes then we can use the below method
    @DataProvider (name = "SignUpData")
    public Object[][] dataCreating() {
//        String str = String.format("blaze");
        Object [][] data = new Object[3][1];
        for(int k=0; k<data.length; k++){
            data[k][0]=(String.format("testt%s@grdp.co", String.valueOf(k)));
        }
        return data;
    }
}
