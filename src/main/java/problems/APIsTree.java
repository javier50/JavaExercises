package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class APIsTree {
    public static void main(String args[]) {
        String[] calls = {"/project1/subproject1/method1",
                "/project2/subproject1/method1",
                "/project1/subproject1/method1",
                "/project1/subproject2/method1",
                "/project1/subproject1/method2",
                "/project1/subproject2/method1",
                "/project2/subproject1/method1",
                "/project1/subproject2/method1"};
        Arrays.stream(solution(calls)).forEach(System.out::println);
    }

    public static String[] solution(String[] calls) {
        Stream.of(calls).sorted().collect(Collectors.toList()).forEach(System.out::println);
        List<String> api = Stream.of(calls).sorted().collect(Collectors.toList());
        List<String> apiTreeList = new ArrayList<>();

        String project = "", subproject = "", method = "";
        Boolean newProject = true, newSubproject = true;
        int countProject = 0, indexProject = 0;
        int countSubproject = 0, indexSubproject = 0;
        int countMethod = 0, indexMethod = 0;
        for(int i = 0; i < api.size(); i++){
            String[] item = api.get(i).split("/");

            if(!project.equals(item[1])){
                if(countProject>0){
                    apiTreeList.set(indexProject, apiTreeList.get(indexProject) + " (" + countProject +")");
                }
                countProject = 1;
                indexProject = apiTreeList.size();

                newProject = true;
                project = item[1];
                apiTreeList.add("--" + project);
            } else {
                newProject = false;
                countProject++;
            }

            if(!subproject.equals(item[2]) || newProject){
                if(countSubproject>0){
                    apiTreeList.set(indexSubproject, apiTreeList.get(indexSubproject) + " (" + countSubproject +")");
                }
                countSubproject = 1;
                indexSubproject = apiTreeList.size();

                newSubproject = true;
                subproject = item[2];
                apiTreeList.add("----" + subproject);
            } else {
                newSubproject = false;
                countSubproject++;
            }

            if(!method.equals(item[3]) || newSubproject){
                if(countMethod>0){
                    apiTreeList.set(indexMethod, apiTreeList.get(indexMethod) + " (" + countMethod +")");
                }
                countMethod = 1;
                indexMethod = apiTreeList.size();

                method = item[3];
                apiTreeList.add("------" + method);
            } else {
                countMethod++;
            }
        }
        apiTreeList.set(indexProject, apiTreeList.get(indexProject) + " (" + countProject +")");
        apiTreeList.set(indexSubproject, apiTreeList.get(indexSubproject) + " (" + countSubproject +")");
        apiTreeList.set(indexMethod, apiTreeList.get(indexMethod) + " (" + countMethod +")");

        String[] apiTree = new String[apiTreeList.size()];
        apiTree = apiTreeList.toArray(apiTree);
        return apiTree;
    }
}
