package ch4_sortingAndSearching;

public class Pair {
    public String getColorName() {
        return colorName;
    }

    public Integer getRank() {
        return rank;
    }

    private String colorName;
        private Integer rank;

        public Pair(String colorName, Integer rank) {
            this.colorName = colorName;
            this.rank = rank;
        }

    @Override
    public String toString() {
        return "Pair{" +
                "colorName='" + colorName + '\'' +
                ", rank=" + rank +
                '}';
    }

    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (colorName != null ? !colorName.equals(pair.colorName) : pair.colorName != null) return false;
            if (rank != null ? !rank.equals(pair.rank) : pair.rank != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = colorName != null ? colorName.hashCode() : 0;
            result = 31 * result + (rank != null ? rank.hashCode() : 0);
            return result;
        }
    }