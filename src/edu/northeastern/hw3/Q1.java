package edu.northeastern.hw3;


abstract class Moody {
    public abstract String getMood();

    public abstract void expressFeelings();

    public void queryMood() {
        System.out.println("I feel " + getMood() + " today!");
    }
}

class Happy extends Moody {
    public String getMood() {
        return "happy";
    }

    public void expressFeelings() {
        System.out.println("heeehee...hahahah...HAHAHA!!");
    }

    public String toString() {
        return "Subject laughs a lot";
    }
}

class Sad extends Moody {
    public String getMood() {
        return "sad";
    }

    public void expressFeelings() {
        System.out.println("'waah''boo hoo' 'weep' 'sob'");
    }

    public String toString() {
        return "Subject cries a lot";
    }
}

class Psychiatrist {
    public void examine(Moody moody) {
        System.out.println("How are you feeling today?");
        moody.queryMood();
    }

    public void observe(Moody moody) {
        moody.expressFeelings();
        System.out.println("Observation: " + moody.toString());
    }
}
public class Q1 {
    public static void main(String[] args) {
        Moody happy = new Happy();
        Moody sad = new Sad();
        Psychiatrist psychiatrist= new Psychiatrist();

        psychiatrist.examine(happy);
        psychiatrist.examine(sad);
        psychiatrist.observe(happy);
        psychiatrist.observe(sad);
    }
}
