import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        String filelocation = "///home/savera/Downloads/sample-example.html";
        String line;
        StringBuilder data = new StringBuilder();
        BufferedReader lineReader = new BufferedReader(new FileReader(filelocation));



        while ((line = lineReader.readLine()) != null) {
            data.append(line).append("\n");
        }
        Pattern appointmentrefPattern = Pattern.compile("([A-Z]{2}\\d{8}-\\d{5})", Pattern.DOTALL);
        Matcher matcher1 = appointmentrefPattern.matcher(data.toString());
        ArrayList<String> appointmentref1 = new ArrayList<>();
        int count = 0;
        while (matcher1.find()) {
            count++;
            appointmentref1.add(matcher1.group());
        }
        System.out.println(appointmentref1.size());


        Pattern patientNamePattern = Pattern.compile("([A-Za-z]{6}\\s[A-Za-z]{5,})", Pattern.DOTALL);
        Matcher matcher2 = patientNamePattern.matcher(data.toString());
        ArrayList<String> patientName1 = new ArrayList<>();
        while (matcher2.find()) {
            count++;
            patientName1.add(matcher2.group());
        }
        System.out.println(patientName1.size());

        Pattern patientAddressPattern = Pattern.compile("(\\w{1,}\\s*\\w{1,}\\s\\w{1,},\\s)?(\\w{1,}\\s)?(\\w{1,},\\s)?(\\w(1,)\\s)?(\\w{1,}\\s)?(\\w{1,}\\s)?(\\w{1,}\\s\\w{1,},\\s)?\\w{1,},\\s*(\\s*|\\w{1,})\\s\\w{1,},\\s\\w{1,},.\\d{5}", Pattern.DOTALL);
        Matcher matcher3 = patientAddressPattern.matcher(data.toString());
        ArrayList<String> patientAddress = new ArrayList<>();
        while (matcher3.find()) {
            count++;
            patientAddress.add(matcher3.group());

        }
        System.out.println(patientAddress.size());


        Pattern patientphonePattern = Pattern.compile("\\(\\d{3}\\)\\s\\d{3}-\\d{4}", Pattern.DOTALL);
        Matcher matcher4 = patientphonePattern.matcher(data.toString());
        ArrayList<String> phone = new ArrayList<>();
        while (matcher4.find()) {
            count++;
            phone.add(matcher4.group());
        }
        System.out.println(phone.size());

        Pattern agentNamePattern = Pattern.compile("[A-Za-z]{3,}\\s+[A-Za-z]{3,}|(N\\/A)",Pattern.DOTALL);
        Matcher matcher5 = agentNamePattern.matcher(data.toString());
        ArrayList<String> agentName1 = new ArrayList<>();
        while (matcher5.find()){
            count++;
            agentName1.add(matcher5.group());
        }
        System.out.println(agentName1.size());




        Pattern apptStatusPattern = Pattern.compile("(COMPLETED|CONFIRMED|AVAILABLE)", Pattern.DOTALL);
        Matcher matcher6 = apptStatusPattern.matcher(data.toString());
        ArrayList<String> apptStatus = new ArrayList<>();
        while (matcher6.find()) {
            count++;
            apptStatus.add(matcher6.group());
        }

        System.out.println(apptStatus.size());


        Pattern TrackingPattern = Pattern.compile("\\s(\\d{5,}|(n\\/a))", Pattern.DOTALL);
        Matcher matcher7 = TrackingPattern.matcher(data.toString());
        ArrayList<String> tracking = new ArrayList<>();
        while (matcher7.find()) {
            count++;
            tracking.add(matcher7.group());
        }
        System.out.println(tracking.size());

        Pattern apptDateTimePattern = Pattern.compile("(\\d{2}\\s[a-zA-Z]{3}\\s\\d{4}\\s\\d{2}:\\d{2}\\s[A-Z]{2})",Pattern.DOTALL);
        Matcher matcher8 = apptDateTimePattern.matcher(data.toString());
        ArrayList<String> apptDateTime = new ArrayList<>();
        while (matcher8.find()){
            count++;
            apptDateTime.add(matcher8.group());

        }
        System.out.println(apptDateTime.size());





        int i;
        int datasize = appointmentref1.size();
        String patientData = "";

        for (i = 0; i < datasize; i++) {
            patientData += appointmentref1.get(i) + "\t" + patientName1.get(i) + "\t" + phone.get(i) + "\t" + patientAddress.get(i) + "\t" + agentName1.get(i) + "\t"  + tracking.get(i) + "\t";
            FileWriter fileWriter = new FileWriter("/home/savera/Desktop/PatientData");
            fileWriter.write(patientData);
            fileWriter.close();
        }



    }
}
