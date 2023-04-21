package Essentials;

import java.util.ArrayList;

public class Route_Stack {

    // Don't need that one
	/* @Override
	public String toString() {
		return "Stack [elements=" + route + "]";
	} */

    private ArrayList<Object> route = new ArrayList<>();

    public Object peek() {
        if (route.isEmpty()) {
            return null;
        }
        return route.get(route.size() - 1);
    }

    public Object pop() {
        if (route.isEmpty()) {
            return null;
        }
        Object top = route.get(route.size() - 1);
        route.remove(route.size() - 1);
        return top;
    }

    public void push(Object element) {
        route.add(element);
    }

    public int size() {
        return route.size();
    }

    public boolean isEmpty() {
        return route.isEmpty();
    }
}