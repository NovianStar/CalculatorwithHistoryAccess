public class Calculator 
{
    private static float result;
    public static float calculation(float variable1, float variable2,int operator)
    {
        switch(operator)
        {
            case(1):
            {
                result = variable1 + variable2;
                break;
            }
            case(2):
            {
                result = variable1 - variable2;
                break;
            }
            case(3):
            {
                result = variable1 * variable2;
                break;
            }
            case(4):
            {
                result = variable1 / variable2;
                break;
            }
            case(5):
            {
                result = variable1 % variable2;
                break;
            }
            default:
            {
                System.out.println("Invalid Operator...");
                break;
            }
        }

        return result;
    }
}
