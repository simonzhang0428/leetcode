package OA_amazon;

/**
 * Third-party companies that sell their products on eBay.com are able to
 * analyze the customer reviews for their products in real time. Imagine that
 * Amazon is creating a category called "five-star sellers" that will only
 * display products sold by companies whose average percentage of five-star
 * reviews per-product is at or above a certain threshold. Given the number of
 * five-star and total reviews for each product a company sells, as well as the
 * threshold percentage, what is the **minimum number of additional fivestar
 * reviews** the company needs to become a five-star seller?
 * 
 * For example, let's say there are 3 products (n = 3) where productRatings =
 * [[4,4], [1,2], [3, 6]], and the percentage ratings Threshold = 77. The first
 * number for each product in productRatings denotes the number of fivestar
 * reviews, and the second denotes the number of total reviews. Here is how we
 * can get the seller to reach the threshold with the minimum number of
 * additional five-star reviews:
 * 
 * Before we add more five-star reviews, the percentage for this seller is ((4 /
 * 4) + (1/2) + (3/6))/3 = 66.66% If we add a five-star review to the second
 * product, the percentage rises to ((4 / 4) + (2/3) +(3/6))/3 = 72.22% If we
 * add another five-star review to the second product, the percentage rises to
 * ((4 / 4) + (3/4) + (3/6))/3 = 75.00% If we add a five-star review to the
 * third product, the percentage rises to ((4/4) + (3/4) + (4/7))/3 = 77.38%
 * 
 * At this point, the threshold of 77% has been met. Therefore, **the answer is
 * 3** because that is the minimum number of additional five-star reviews the
 * company needs to become a five-star seller.
 ** 
 * Function Description**
 * 
 * Complete the function fiveStarReviews in the editor below.
 * 
 * fiveStarReviews has the following parameters:
 * 
 * int productRatings[n][2]: a 2-dimensional array of integers where the ith
 * element contains two values, the first one denoting fivestar[i] and the
 * second denoting total[i]
 * 
 * int ratingsThreshold: the threshold percentage, which is the average
 * percentage of five-star reviews the products need for the company to be
 * considered a five-star seller
 * 
 * Returns:
 * 
 * int: the minimum number of additional five-star reviews the company needs to
 * meet the threshold ratingsThreshold
 ** 
 * Constraints**
 * 
 * 1<=n<=200 0 <= fivestar<total<=100 1<=ratingsThreshold<100 The array
 * productRatings contains only non-negative integers.
 */
public class FiveStar {
    public static void main(String[] args) {
        int[][] productRatings = new int[][] { { 4, 4 }, { 1, 2 }, { 3, 6 } };
        int ratingsThreshold = 77;
        System.out.println(fiveStarReviews(productRatings, ratingsThreshold));
    }

    public static int fiveStarReviews(int[][] productRatings, int ratingsThreshold) {
        int target = ratingsThreshold * productRatings.length;
        int count = 0;
        double sum = 0;
        double maxDelta = 0;
        int index = 0;

        while (sum * 100 < target) {
            sum = 0;
            maxDelta = 0;

            for (int i = 0; i < productRatings.length; i++) {
                double avg = calculateAvg(productRatings[i][0], productRatings[i][1]);
                double delta = calculateDelta(productRatings[i][0], productRatings[i][1], avg);
                if (maxDelta < delta) {
                    maxDelta = delta;
                    index = i;
                }
                sum += avg;
            }

            if (sum * 100 < target) {
                count++;
                productRatings[index][0] = productRatings[index][0] + 1;
                productRatings[index][1] = productRatings[index][1] + 1;
                sum += maxDelta;
                // System.out.println(sum);
            }
        }
        
        return count;
    }

    private static double calculateAvg(int review, int total) {
        return (double) review / total;
    }

    private static double calculateDelta(int review, int total, double average) {
        return ((double) (review + 1) / (total + 1)) - average;
    }
}
