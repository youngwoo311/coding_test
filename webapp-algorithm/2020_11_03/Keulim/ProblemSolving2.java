/**
 * https://programmers.co.kr/learn/courses/30/lessons/42893
 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemSolving2 {

    public class Page implements Comparable<Page> {
        int index;
        int basicScore;
        String url;
        String page;
        String word;
        double linkScore = 0.0;
        List<String> externalLinks = new ArrayList<>();

        public Page(int index, String page, String word) {
            this.index = index;
            this.page = page;
            this.word = word;
            setUrl();
            setBasicScore();
        }

        private void setUrl() {
            Matcher urlM = Pattern.compile("<meta property=\"og:url\" content=\"https://(.+?)\"/>").matcher(page);
            while (urlM.find()) {
                this.url = urlM.group(1);
            }
        }

        private void setBasicScore() {
            String rpage = page.toLowerCase().replaceAll("[^a-z]", " ");
            Matcher wordM = Pattern.compile("(\\b" + word + "\\b)", Pattern.CASE_INSENSITIVE).matcher(rpage);
            int wordCount = 0;
            while (wordM.find()) {
                wordCount++;
            }
            this.basicScore = wordCount;
        }

        private void setLinks() {
            Matcher linkM = Pattern.compile("<a href=\"https://(.+?)\">").matcher(page);
            while (linkM.find()) {
                String link = linkM.group(1);
                this.externalLinks.add(link);
            }
        }

        private void calculateLinkScore() {
            for (String externalLink : this.externalLinks) {
                Page externalPage = pageMap.get(externalLink);
                externalPage.linkScore += (double) this.basicScore / this.externalLinks.size();
            }
        }

        @Override
        public int compareTo(Page o) {
            if (this.linkScore + this.basicScore == o.linkScore + o.basicScore) {
                return Integer.compare(this.index, o.index);
            }
            return Double.compare(o.linkScore + o.basicScore, this.linkScore + this.basicScore);
        }
    }

    private Map<String, Page> pageMap = new HashMap<>();

    public int solution(String word, String[] pages) {
        for (int i = 0; i < pages.length; i++) {
            Page page = new Page(i, pages[i], word);
            pageMap.put(page.url, page);
            page.setLinks();
        }

        for (Page page : pageMap.values()) {
            page.calculateLinkScore();
        }

        List<Page> all = new ArrayList<>(pageMap.values());
        Collections.sort(all);

        return all.get(0).index;
    }
}
