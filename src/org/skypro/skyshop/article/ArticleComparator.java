package org.skypro.skyshop.article;
import java.util.Comparator;

public class ArticleComparator implements Comparator<Article> {
    @Override
    public int compare(Article a1, Article a2) {
        int lengthComparison = Integer.compare(a2.getObjName().length(), a1.getObjName().length());
        if (lengthComparison != 0) {
            return lengthComparison;
        }
        return a1.getObjName().compareTo(a2.getObjName());
    }
}
