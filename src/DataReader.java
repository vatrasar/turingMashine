import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DataReader {


    private String alphabetTape;
    private String alphabetIn;
    private String inWord;
    private List<State>stateList;
    private Map<TransitionKey,Transition> transitionsMap;
    State startState;

    public DataReader(String inFileName) {

        try {
            Scanner scanner=new Scanner(new File(inFileName));


            //get data from file
            scanner.nextLine();
            alphabetTape=scanner.nextLine();

            scanner.nextLine();
            alphabetIn=scanner.nextLine();
            scanner.nextLine();
            inWord=scanner.nextLine();
            scanner.nextLine();
            String states=scanner.nextLine();
            scanner.nextLine();
            String startStates = scanner.nextLine();
            scanner.nextLine();
            String acceptStates = scanner.nextLine();


            //create states List
            List<Integer>stateIdList=convertStringToIndexList(states);
            List<Integer>startStatesList=convertStringToIndexList(startStates);
            List<Integer>acceptStatesList=convertStringToIndexList(acceptStates);
            stateList=new ArrayList<>();
            for(Integer id:stateIdList)
            {


                boolean isStart=false;
                boolean isFinish=false;
                if(startStatesList.contains(id))
                {
                    isStart=true;

                }
                if(acceptStatesList.contains(id))
                {
                    isFinish=true;
                }
                State newState=new State(id,isFinish,isStart);
                if(isStart)
                    this.startState=newState;
                stateList.add(newState);

            }


            //relations matrix
            transitionsMap=new HashMap<>();
            scanner.nextLine();

            while (scanner.hasNextLine())
            {
                String relationLine=scanner.nextLine();

                String[] relationsElements=relationLine.split(" ");
                int stateId=Integer.parseInt(relationsElements[0]);
                String inChar=relationsElements[1];
                int nextStateId=Integer.parseInt(relationsElements[2]);
                String outChar=relationsElements[3];
                String directionChar=relationsElements[4];
                Diretion diretion=null;
                if(directionChar.equals("L"))
                {
                    diretion=Diretion.LEFT;
                }else {
                    diretion=Diretion.RIGHT;
                }
                State nextState=getStateFromList(stateList,nextStateId);


                Transition transition=new Transition(inChar,outChar,diretion,nextState);
                State startState=getStateFromList(stateList,stateId);
                transitionsMap.put(new TransitionKey(startState,transition.inChar) , transition);
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public State getStartState() {
        return startState;
    }

    private  State getStateFromList(List<State> stateList, int nextStateId) {

        for(State state:stateList)
        {
            if(state.id==nextStateId)
                return state;
        }
        return null;
    }

    private List<Integer>convertStringToIndexList(String in)
    {
        String[] array=in.split(" ");
        List<Integer>indexList=new ArrayList<>();
        for(String indexString:array)
        {
            indexList.add(Integer.parseInt(indexString));
        }
        return indexList;
    }

    public String getAlphabetTape() {
        return alphabetTape;
    }

    public String getAlphabetIn() {
        return alphabetIn;
    }

    public String getInWord() {
        return inWord;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public Map<TransitionKey, Transition> getTransitionsMap() {
        return transitionsMap;
    }
}