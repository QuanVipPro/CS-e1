package a_pe_csd_de1;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountryManager {
    public List<Country> readCSVFile(String filePath){
        List<Country> countries = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){ // Đọc file
            String line;
            while((line=br.readLine())!= null){
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)",-1); // Chuỗi String
                // -1 : Không hạn chế số lượng phẩn từ sẽ được split
                String countryCode = data[0].trim();
                // String
                int rank = Integer.parseInt((data[1].trim()));
                String name = data[3].trim();
                String gpa = data[4].trim();
                // CÓ THỂ CHANGE
                countries.add(new Country(countryCode,rank,name,gpa));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return countries;
    }
    public void quickSort(List<Country> list, int low, int high)
    {
        if (low < high)
        {
        /* pi is partitioning index, arr[p] is now
           at right place */
            int pi = partition(list, low, high);

            quickSort(list, low, pi - 1);  // Before pi
            quickSort(list, pi + 1, high); // After pi
        }
    }
    private int partition(List<Country> list, int low, int high)
    {
        Country pivot = list.get(high);
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (list.get(j).compareTo(pivot) <= 0) // list.get(j) < pivot => -1
            {
                i++;

                // swap arr[i] and arr[j]
                swap(list,i,j);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        swap(list,i+1,high);

        return i+1;
    }
    private void swap(List<Country> array, int i, int j){
        Country temp = array.get(i);
        array.set(i,array.get(j));
        array.set(j,temp);
    }

    public static void main(String[] args) {
        List<Country> list = new ArrayList<>();
        CountryManager test = new CountryManager();
        list = test.readCSVFile("D:\\java\\a_PE_CSD_de1\\congnguyen.csv");
//        for(Country co : list){
//            System.out.println(co.toString());
//        }
        test.quickSort(list,0, list.size()-1);
        for(Country co : list){
            System.out.println(co.toString());
        }
         AVLTree avlTree = new AVLTree();
        AVLNode root = null;
        root = avlTree.insertList(root, list);

       System.out.println(avlTree.countCountryNamesStartingWith(root,'A'));


    }

}
