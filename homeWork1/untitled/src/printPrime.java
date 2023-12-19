public class printPrime {
    public static void main(String[] args) {

        AnswerPrime ans = new AnswerPrime();
        ans.printPrimeNums();
    }
}

class AnswerPrime {
    public void printPrimeNums() {
        // Напишите свое решение ниже
        for (int i=1;i<=1000;i++){
            if (isPrime(i)){
                System.out.println(i);
            }
        }

    }

    public boolean isPrime(int num) {
        if (num == 2) return true;
        else if (num % 2 == 0 || num == 1) return false;
        boolean result = false;
        for (int count = 3; count <= Math.sqrt(num); count += 2) {
            if (num % count == 0) {
                return result;
            }

        }
        result = true;
        return result;

    }
}