/**
 * https://programmers.co.kr/learn/courses/30/lessons/60061
 */

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ProblemSolving1 {

    public int[][] solution(int n, int[][] build_frame) {
        BuildSet bs = new BuildSet(n);

        for (int[] frame : build_frame) {
            if (frame[2] == 0) { // 기둥
                bs.handleColumn(frame[3], frame[0], -frame[1] + n);
            } else {
                bs.handleBeam(frame[3], frame[0], -frame[1] + n);
            }
        }

        return bs.getStructure();
    }

    private static class BuildSet {
        private int n;
        private Set<Node> set = new HashSet<>();

        BuildSet(int n) {
            this.n = n;
        }

        void handleColumn(int method, int y, int x) {
            boolean res = checkColumn(y, x);
            if (!res) return;

            Node node = new Node(0, y, x);
            if (method == 0) {   // disassemble
                set.remove(node);
                if (set.contains(new Node(1, y - 1, x - 1)) && !checkBeam(y - 1, x - 1)
                        || set.contains(new Node(1, y, x - 1)) && !checkBeam(y, x - 1)
                        || set.contains(new Node(0, y, x - 1)) && !checkColumn(y, x - 1)) {
                    set.add(node);
                }

            } else {    // set up
                set.add(node);
            }
        }

        private boolean checkColumn(int y, int x) {  // 0 기둥 체크
            return x == n ||    // 바닥 위
                    set.contains(new Node(1, y, x)) ||   // 보의 오른 쪽 끝 부분 위
                    set.contains(new Node(1, y - 1, x)) ||   // 보의 왼쪽 끝 부분 위
                    set.contains(new Node(0, y, x + 1));   // 다른 기둥 위
        }

        void handleBeam(int method, int y, int x) {
            boolean res = checkBeam(y, x);
            if (!res) return;

            Node node = new Node(1, y, x);
            if (method == 0) {   // disassemble
                set.remove(node);
                if (set.contains(new Node(1, y - 1, x)) && !checkBeam(y - 1, x) ||
                        set.contains(new Node(0, y, x)) && !checkColumn(y, x) ||
                        set.contains(new Node(1, y + 1, x)) && !checkBeam(y + 1, x) ||
                        set.contains(new Node(0, y + 1, x)) && !checkColumn(y + 1, x)) {
                    set.add(node);
                }
            } else {    // set up
                set.add(node);
            }
        }

        private boolean checkBeam(int y, int x) {  // 1 보 체크
            return (set.contains(new Node(1, y - 1, x)) &&  // 양쪽 끝 부분이 다른 보와 동시에 연결
                    set.contains(new Node(1, y + 1, x))) ||
                    set.contains(new Node(0, y, x + 1)) ||   // 왼쪽 끝이 기둥 위에
                    set.contains(new Node(0, y + 1, x + 1));  // 오른쪽 끝이 기둥 위에
        }

        int[][] getStructure() {
            return this.set
                    .stream()
                    .sorted((o1, o2) -> {
                        if (o1.y == o2.y) {
                            if (o1.x == o2.x) {
                                return Integer.compare(o1.kind, o2.kind);
                            }
                            return Integer.compare(-o1.x + n, -o2.x + n);
                        }
                        return Integer.compare(o1.y, o2.y);
                    }).map(e -> new int[]{e.y, -e.x + n, e.kind})
                    .toArray(int[][]::new);
        }
    }

    private static class Node {
        private int kind;
        private int x;
        private int y;

        Node(int kind, int y, int x) {
            this.kind = kind;
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return kind == node.kind &&
                    x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(kind, x, y);
        }
    }
}
