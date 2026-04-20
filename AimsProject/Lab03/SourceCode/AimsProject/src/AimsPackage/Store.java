package AimsPackage;

public class Store {

    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[50];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < itemsInStore.length) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The dvd '" + dvd.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("The store is full.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean isFound = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                isFound = true;

                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null; 
                qtyInStore--;
                System.out.println("The dvd '" + dvd.getTitle() + "' has been removed from the store.");
                break;
            }
        }
        if (!isFound) {
            System.out.println("The dvd '" + dvd.getTitle() + "' is not in the store.");
        }
    }
}