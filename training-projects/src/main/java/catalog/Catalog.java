package catalog;


import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        if (catalogItem == null) {
            throw new IllegalArgumentException("Catalog item must be provided!");
        }
        catalogItems.add(catalogItem);
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        List<CatalogItem> toRemove = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.getRegistrationNumber().equals(registrationNumber)) {
                toRemove.add(item);
            }
        }
        catalogItems.removeAll(toRemove);
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem item:catalogItems) {
            if(checkCriteria(item,searchCriteria)){
                result.add(item);
            }
        }
        return result;

    }

    private boolean checkCriteria(CatalogItem item, SearchCriteria criteria) {
        boolean checkTitle = !criteria.hasTitle() || item.getTitles().contains(criteria.getTitle());
        boolean checkContributor = !criteria.hasContributor() || item.getContributors().contains(criteria.getContributor());
        return checkTitle && checkContributor;
    }

    public int getFullLength() {
        int fullLength = 0;
        for (CatalogItem item : catalogItems) {
            fullLength += item.fullLengthAtOneItem();
        }
        return fullLength;
    }

    public int getAllPageNumber() {
        int allPageNumber = 0;
        for (CatalogItem item : catalogItems) {
            allPageNumber += item.numberOfPagesAtOneItem();
        }
        return allPageNumber;
    }

    public double averagePageNumberOver(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }
        double sum = 0;
        int count = 0;
        for (CatalogItem item : catalogItems) {
            int actualPagesNumber = item.numberOfPagesAtOneItem();
            if (actualPagesNumber > limit) {
                sum += actualPagesNumber;
                count++;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("No page");
        }
        return sum / count;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioItems = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasAudioFeature()) {
                audioItems.add(item);
            }
        }
        return audioItems;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedItems = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature()) {
                printedItems.add(item);
            }
        }
        return printedItems;
    }

}
