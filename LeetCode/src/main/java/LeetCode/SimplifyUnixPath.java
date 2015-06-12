package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-6-12
 * Time: 下午6:11
 * To change this template use File | Settings | File Templates.
 */

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 path = "/../", => "/"
 path = "/home//foo/", => "/home/foo"
 */
public class SimplifyUnixPath {

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        Stack<String> stack = new Stack<String>();

        String[] elems = path.split("/");
        for (String elem : elems) {
            if (elem.equals(".") || elem.equals("")) {
                continue;
            } else if (elem.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(elem);
            }
        }
        if (stack.isEmpty()) return "/";
        LinkedList<String> result = new LinkedList<String>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append("/").append(result.pop());
        }
        return sb.toString();

    }

    public String simplifyPath2(String path) {
        Stack<String> stack = new Stack<String>();

        //stack.push(path.substring(0,1));

        while(path.length()> 0 && path.charAt(path.length()-1) =='/'){
            path = path.substring(0, path.length()-1);
        }

        int start = 0;
        for(int i=1; i<path.length(); i++){
            if(path.charAt(i) == '/'){
                stack.push(path.substring(start, i));
                start = i;
            }else if(i==path.length()-1){
                stack.push(path.substring(start));
            }
        }

        LinkedList<String> result = new LinkedList<String>();
        int back = 0;
        while(!stack.isEmpty()){
            String top = stack.pop();

            if(top.equals("/.") || top.equals("/")){
                //nothing
            }else if(top.equals("/..")){
                back++;
            }else{
                if(back > 0){
                    back--;
                }else{
                    result.push(top);
                }
            }
        }

        //if empty, return "/"
        if(result.isEmpty()){
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty()){
            String s = result.pop();
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyUnixPath simplifyUnixPath = new SimplifyUnixPath();
        System.out.println(simplifyUnixPath.simplifyPath("/home/"));
        System.out.println(simplifyUnixPath.simplifyPath("/../"));
        System.out.println(simplifyUnixPath.simplifyPath("/home//foo/"));
        System.out.println(simplifyUnixPath.simplifyPath("/a/./b/../../c/"));
    }


}
