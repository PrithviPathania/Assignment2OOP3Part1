package utilities;
//array list

/*
 *  appropriate pre-conditions, post-conditions,
	parameters, return values and expected exceptions using proper Javadoc notations
 */
public interface StackADT {

	
	
    /**
     * The ability to add to the top of a stack
     * Precondition: the value to be added must not be null, and the stack must not be full.
     * Postcondition: the value is added to the top of the stack, and the size of the stack is increased by one. the size of the stack after the value is added to the top of the stack is returned.
     * @param value the value to be added to the top of the stack
     * @throws NullPointerException if the value to be added is null
     * @throws IllegalStateException if the stack is full
     * @return the size of the stack after the value is added to the top of the stack
     * 
     *
     */
    void push();


    /**
     * The ability to remove the element from the top of the stack
     * Precondition:
     * Postcondition:
     * @param
     * @throws
     *
     *
     *
     */


    void pop();

    /**
     * The ability to look up the first value within the stack ( the one at the very top of the stack)
     * Precondition: A stack must exist
     * Postcondition: returns value at the top of the stack
     * @param
     * @returns returns value at the top of the stack
     */

    V peek();







}
