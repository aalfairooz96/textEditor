import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class textAnalysis {
	static ArrayList<String> fileString;
	static ArrayList<String> filledFileString;
    
	static int maxChar;
	static int numSpace;
    static int numofWords;
    static int numLR=0;
    static int wPL;
    static int lPL;
    static int numLines;
    static int numChar;
    
    String rLine;
   

    textAnalysis(String inputFile){

        rLineLimit(inputFile,maxChar);
        fullJustify(maxChar,inputFile);
    }

    public void rLineLimit(String path, int sizeW)
    {
        FileInputStream file = null;
        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int lines =1;
        String fileContent;
        try {
            File file1 = new File(path);
            byte[] buffer = new byte[(int)file1.length()];
            FileInputStream input = new FileInputStream(file1);
            input.read(buffer);
            fileContent = new String(buffer, "UTF-8");

            String [] splitT = fileContent.split("\\s+");
            ArrayList<String> rList = new ArrayList<String>();
            String rLine = "";

            for (int i = 0; i < splitT.length; i++) {
                if (rLine.length() + splitT[i].length() >= sizeW) {
                    rList.add(rLine.trim());
                    rLine = splitT[i]+ " ";
                } else {
                    rLine += splitT[i] + " ";
                }

                if (i == splitT.length - 1)
                {
                    rList.add(rLine.trim());

                }
            }


            fileString = rList;

            //System.out.println(fileString);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void fullJustify(int sizeW, String path) {

        String[] ofWords;
        List<String> result = new ArrayList<String>();


        for (String lost : ofWords = fileString.toArray(new String[0])) {
        }

        if(ofWords.length == 0){
            filledFileString = (ArrayList<String>) result;
        }


        int count=0;
        int end=0;
        int count2 = 0;
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i<ofWords.length; i++){
            count = count + ofWords[i].length();

            //System.out.println(ofWords[i]  );


            if(count+i-end>sizeW){
            	
                int ofWordsLen = count-ofWords[i].length();
                int spaceLen = sizeW-ofWordsLen;
                int eachLen = 1;
                int extraLen = 0;

                if(i-end-1>0){
                    eachLen = spaceLen/(i-end-1);
                    extraLen = spaceLen%(i-end-1);
                }

                StringBuilder buildString = new StringBuilder();

                for(int k=end; k<i-1; k++){
                    buildString.append(ofWords[k]);

                    int ce = 0;
                    while(ce<eachLen){
                        buildString.append(" ");
                        ce++;
                    }

                    if(extraLen>0){
                        buildString.append(" ");
                        extraLen--;
                    }
                }

                buildString.append(ofWords[i-1]);//end ofWords in the rLine
                //if only one word in this rLine, need to fill left with space
                int rand = 1;

                for (int j = 0; j < buildString.length() && (buildString.length() < sizeW-1); j++) {
                    if (buildString.charAt(j) == ' ') {
                        if (rand == 1) {
                            buildString.insert(j, " ");
                            count2++;
                            j = j + 2;
                        } else
                            rand = 0;
                    }
                }

                for (int j = 0; j < buildString.length() && (buildString.length() < sizeW-1); j++) {
                    if (buildString.charAt(j) == ' ' && buildString.charAt(j+1) == ' ') {
                        if (rand == 1) {
                            buildString.insert(j, " ");
                            count2++;
                            j = j + 2;
                        } else
                            rand = 0;
                    }
                }

                for (int j = 0; j < buildString.length() && (buildString.length() < sizeW-1); j++) {
                    if (buildString.charAt(j) == ' ' && buildString.charAt(j+1) == ' ' && buildString.charAt(j+2) == ' ') {
                        if (rand == 1) {
                            buildString.insert(j, " ");
                            count2++;
                            j = j + 2;
                        } else
                            rand = 0;
                    }
                }

                for (int j = 0; j < buildString.length() && (buildString.length() < sizeW-1); j++) {
                    if (buildString.charAt(j) == ' ' && buildString.charAt(j+1) == ' ' && buildString.charAt(j+2) == ' ' && buildString.charAt(j+3) == ' ' ) {
                        if (rand == 1) {
                            buildString.insert(j, " ");
                            count2++;
                            j = j + 2;
                        } else
                            rand = 0;
                    }
                }

                for (int j = 0; j < buildString.length() && (buildString.length() < sizeW-1); j++) {
                    if (buildString.charAt(j) == ' ' && buildString.charAt(j+1) == ' ' && buildString.charAt(j+2) == ' ' && buildString.charAt(j+3) == ' '
                            && buildString.charAt(j+4) == ' ') {
                        if (rand == 1) {
                            buildString.insert(j, " ");
                            count2++;
                            j = j + 2;
                        } else
                            rand = 0;
                    }
                }

                for (int j = 0; j < buildString.length() && (buildString.length() < sizeW-1); j++) {
                    if (buildString.charAt(j) == ' ' && buildString.charAt(j+1) == ' ' && buildString.charAt(j+2) == ' '
                            && buildString.charAt(j+3) == ' ' && buildString.charAt(j+4) == ' ' && buildString.charAt(j+5) == ' ') {
                        if (rand == 1) {
                            buildString.insert(j, " ");
                            count2++;
                            j = j + 2;
                        } else
                            rand = 0;
                    }
                }

                for (int j = 0; j < buildString.length() && (buildString.length() < sizeW-1); j++) {
                    if (buildString.charAt(j) == ' ' && buildString.charAt(j+1) == ' ' && buildString.charAt(j+2) == ' '
                            && buildString.charAt(j+3) == ' ' && buildString.charAt(j+4) == ' ' && buildString.charAt(j+5) == ' '
                            && buildString.charAt(j+6) == ' ') {
                        if (rand == 1) {
                            buildString.insert(j, " ");
                            count2++;
                            j = j + 2;
                        } else
                            rand = 0;
                    }
                }

                for (int j = 0; j < buildString.length() && (buildString.length() < sizeW-1); j++) {
                    if (buildString.charAt(j) == ' ' && buildString.charAt(j+1) == ' ' && buildString.charAt(j+2) == ' '
                            && buildString.charAt(j+3) == ' ' && buildString.charAt(j+4) == ' ' && buildString.charAt(j+5) == ' '
                            && buildString.charAt(j+6) == ' ' && buildString.charAt(j+7) == ' ') {
                        if (rand == 1) {
                            buildString.insert(j, " ");
                            count2++;
                            j = j + 2;
                        } else
                            rand = 0;
                    }
                }

                for (int j = 0; j < buildString.length() && (buildString.length() < sizeW-1); j++) {
                    if (buildString.charAt(j) == ' ' && buildString.charAt(j+1) == ' ' && buildString.charAt(j+2) == ' '
                            && buildString.charAt(j+3) == ' ' && buildString.charAt(j+4) == ' ' && buildString.charAt(j+5) == ' '
                            && buildString.charAt(j+6) == ' ' && buildString.charAt(j+7) == ' ' && buildString.charAt(j+8) == ' ' ) {
                        if (rand == 1) {
                            buildString.insert(j, " ");
                            count2++;
                            j = j + 2;
                        } else
                            rand = 0;
                    }
                }

                for (int j = 0; j < buildString.length() && (buildString.length() < sizeW-1); j++) {
                    if (buildString.charAt(j) == ' ' && buildString.charAt(j+1) == ' ' && buildString.charAt(j+2) == ' '
                            && buildString.charAt(j+3) == ' ' && buildString.charAt(j+4) == ' ' && buildString.charAt(j+5) == ' '
                            && buildString.charAt(j+6) == ' ' && buildString.charAt(j+7) == ' ' && buildString.charAt(j+8) == ' '
                            && buildString.charAt(j+9) == ' ') {
                        if (rand == 1) {
                            buildString.insert(j, " ");
                            count2++;
                            j = j + 2;
                        } else
                            rand = 0;
                    }
                }

                for (int j = 0; j < buildString.length() && (buildString.length() < sizeW-1); j++) {
                    if (buildString.charAt(j) == ' ' && buildString.charAt(j+1) == ' ' && buildString.charAt(j+2) == ' '
                            && buildString.charAt(j+3) == ' ' && buildString.charAt(j+4) == ' ' && buildString.charAt(j+5) == ' '
                            && buildString.charAt(j+6) == ' ' && buildString.charAt(j+7) == ' ' && buildString.charAt(j+8) == ' '
                            && buildString.charAt(j+9) == ' ' && buildString.charAt(j+10) == ' ') {
                        if (rand == 1) {
                            buildString.insert(j, " ");
                            count2++;
                            j = j + 2;
                        } else
                            rand = 0;
                    }
                }


                result.add(buildString.toString());

                end = i;
                count=ofWords[i].length();
            }
        }


        int endLen = 0;
        StringBuilder buildString = new StringBuilder();

        for(int i=end; i<ofWords.length-1; i++){
            count = count+ofWords[i].length();
            buildString.append(ofWords[i]+" ");
        }

        buildString.append(ofWords[ofWords.length-1]);

        while(buildString.length()<sizeW){
            buildString.append(" ");
        }
        result.add(buildString.toString());

//        for(int i =0; i<result.size();i++){
//            System.out.println(result.get(i));
//        }
        numSpace = count2;
        filledFileString = (ArrayList<String>) result;


        int numofWords1 = 0;
        int numChar1 = 0;
        int rLinerem = 0;

        FileInputStream file = null;
        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        InputStreamReader input = new InputStreamReader(file);
        BufferedReader reader = new BufferedReader(input);

        try {
            while((rLine = reader.readLine()) != null)
            {
                if(!(rLine.equals("")))
                {
                    numChar1 += rLine.length();
                    String[] wordList = rLine.split("\\s+");     // \\s+ is the space delimiter in java
                    numofWords1 += wordList.length;
                }
                else
                {
                    rLinerem++;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        numChar = numChar1;
        numofWords = numofWords1;
        numLR = rLinerem;

        int l = fileString.size();
        numLines = l;
        wPL = numofWords1/l;
        lPL = numChar1/l;

    }

}