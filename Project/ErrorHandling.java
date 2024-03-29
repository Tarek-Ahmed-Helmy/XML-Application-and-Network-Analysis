import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrorHandling {
    public static void solveError(String str, BufferedWriter bw) throws IOException {
    	StringReader reader = new StringReader(str);
    	BufferedReader br = new BufferedReader(reader);
        Pattern opening_tag= Pattern.compile("<(\\w+)>"), opening_tag_W= Pattern.compile("<(\\w+)>\\w+"), closing_tag= Pattern.compile("</(\\w+)>");
        Matcher matcher_opening_tag, matcher_opening_tag_W, matcher_closing_tag;
        Stack<TagError> stack = new Stack<>();
        String line=br.readLine();
        while(line!=null){
            matcher_opening_tag=opening_tag.matcher(line);
            matcher_opening_tag_W=opening_tag_W.matcher(line);
            matcher_closing_tag=closing_tag.matcher(line);
            boolean open=matcher_opening_tag.find(), open_W=matcher_opening_tag_W.find(), close=matcher_closing_tag.find();
            boolean checkIfNoErrors=true;
            if(open){
                TagError error = new TagError(matcher_opening_tag.group(1));
                stack.push(error);
            }
            if(open_W && !close){
                bw.append(line).append("</").append(matcher_opening_tag.group(1)).append(">\n");
                checkIfNoErrors=false;
                stack.pop();
            }
            else if(open && close){
                if(matcher_opening_tag.group(1).equals(matcher_closing_tag.group(1))){
                    stack.pop();
                }
                else{
                    String line2=line.replaceAll(opening_tag.toString(), "<"+matcher_closing_tag.group(1)+">");
                    bw.append(line2).append(String.valueOf('\n'));
                    checkIfNoErrors=false;
                    stack.pop();
                }
            }
            else if(close) {
                while(!(stack.peek().content.equals(matcher_closing_tag.group(1))&&!stack.isEmpty())) {
                    bw.append("</").append(stack.peek().content).append(">\n");
                    stack.pop();
                }
                if(!stack.isEmpty())
                    stack.pop();
            }
            if(checkIfNoErrors)
                bw.append(line).append(String.valueOf('\n'));
            line=br.readLine();
        }
        while (!stack.isEmpty()){
            bw.append("</").append(stack.peek().content).append(">\n");
            stack.pop();
        }
    }

    public static boolean consistency(String str) throws IOException {
    	StringReader reader = new StringReader(str);
    	BufferedReader br = new BufferedReader(reader);
        Pattern opening_tag= Pattern.compile("<(\\w+)>"), closing_tag= Pattern.compile("</(\\w+)>");
        Matcher matcher_opening_tag, matcher_closing_tag;
        Stack<String> stack = new Stack<>();
        String line=br.readLine();
        while(line!=null){
            matcher_opening_tag=opening_tag.matcher(line);
            matcher_closing_tag=closing_tag.matcher(line);

            if(matcher_opening_tag.find()){
                stack.push(matcher_opening_tag.group(1));
            }
            if(matcher_closing_tag.find()) {
                if ((stack.peek().equals(matcher_closing_tag.group(1)))) {
                    stack.pop();
                }
                else return false;
            }
            line=br.readLine();
        }
        return stack.isEmpty();
    }

    public static void showError(String str) throws IOException {
    	StringReader reader = new StringReader(str);
    	BufferedReader br = new BufferedReader(reader);
        int lineNumber=1;
        Pattern opening_tag= Pattern.compile("<(\\w+)>"), opening_tag_W= Pattern.compile("<(\\w+)>\\w+"), closing_tag= Pattern.compile("</(\\w+)>");
        Matcher matcher_opening_tag, matcher_opening_tag_W, matcher_closing_tag;
        Stack<TagError> stack = new Stack<>();
        String line=br.readLine();
        while(line!=null){
            matcher_opening_tag=opening_tag.matcher(line);
            matcher_opening_tag_W=opening_tag_W.matcher(line);
            matcher_closing_tag=closing_tag.matcher(line);
            boolean open=matcher_opening_tag.find(), open_W=matcher_opening_tag_W.find(), close=matcher_closing_tag.find();
            if(open){
                TagError error = new TagError(lineNumber,matcher_opening_tag.group(1));
                stack.push(error);
            }
            if(open_W && !close){
                System.out.println("error in line: " +stack.peek().lineNumber);
                System.out.println("Missing closing tag </"+stack.peek().content+">" );
                stack.pop();
            }
            else if(open && close){
                if(matcher_opening_tag.group(1).equals(matcher_closing_tag.group(1))){
                    stack.pop();
                }
                else{
                    System.out.println("error in line: " +stack.peek().lineNumber);
                    System.out.println("Wrong opening tag <"+matcher_opening_tag.group(1)+">" );
                    stack.pop();
                }
            }
            else if(close) {
                int errorLineNumber = lineNumber;
                while(!(stack.peek().content.equals(matcher_closing_tag.group(1))&&!stack.isEmpty())) {
                    System.out.println("error in line: " + (errorLineNumber++-1));
                    System.out.println("Missing closing tag </"+stack.peek().content+">" );
                    stack.pop();
                }
                if(!stack.isEmpty())
                    stack.pop();
            }
            line=br.readLine();
            lineNumber++;
        }
        while (!stack.isEmpty()){
            System.out.println("error in line: " + lineNumber++);
            System.out.println("Missing closing tag </"+stack.peek().content+">" );
            stack.pop();
        }
    }
}