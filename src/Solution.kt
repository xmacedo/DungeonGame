class Solution {
    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val m = dungeon.size
        val n = dungeon[0].size
        val dp = Array(m + 1) { IntArray(n + 1) { Int.MAX_VALUE } }

        dp[m][n - 1] = 1
        dp[m - 1][n] = 1

        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                val minHealth = minOf(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]
                dp[i][j] = maxOf(1, minHealth)
            }
        }

        return dp[0][0]
    }
}

