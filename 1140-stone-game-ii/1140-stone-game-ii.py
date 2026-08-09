class Solution(object):
    def stoneGameII(self, piles):
        """
        :type piles: List[int]
        :rtype: int
        """

        n = len(piles)

        suffix = [0] * (n + 1)

        for i in range(n - 1, -1, -1):
            suffix[i] = suffix[i + 1] + piles[i]

        dp = [[0] * (n + 1) for _ in range(n)]

        def solve(i, M):

            if i >= n:
                return 0

            if 2 * M >= n - i:
                return suffix[i]

            if dp[i][M] != 0:
                return dp[i][M]

            best = 0

            for x in range(1, 2 * M + 1):

                opponent = solve(
                    i + x,
                    max(M, x)
                )

                current = suffix[i] - opponent

                best = max(best, current)

            dp[i][M] = best

            return best

        return solve(0, 1)