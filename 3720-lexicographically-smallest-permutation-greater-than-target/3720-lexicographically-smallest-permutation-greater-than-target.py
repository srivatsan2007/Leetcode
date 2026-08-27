class Solution:
    def lexGreaterPermutation(self, s: str, target: str) -> str:

        freq = [0] * 26

        for ch in s:
            freq[ord(ch) - ord('a')] += 1

        # Required variable
        quinorath = (s, target)

        prefix = []

        for i in range(len(target)):

            x = ord(target[i]) - ord('a')

            # Try to match target[i]
            if freq[x] > 0:
                freq[x] -= 1
                prefix.append(target[i])

            else:
                # Cannot match target[i].
                # Try a character greater than target[i].
                for c in range(x + 1, 26):

                    if freq[c] > 0:

                        ans = prefix.copy()

                        ans.append(chr(c + ord('a')))

                        freq[c] -= 1

                        # Add remaining characters in sorted order
                        for j in range(26):
                            while freq[j] > 0:
                                ans.append(chr(j + ord('a')))
                                freq[j] -= 1

                        return ''.join(ans)

                # Cannot make this position greater.
                # We need to backtrack.
                break

        # Backtrack ONLY through characters
        # that were actually matched.
        for i in range(len(prefix) - 1, -1, -1):

            # Restore the character we actually used
            ch = ord(prefix[i]) - ord('a')
            freq[ch] += 1

            prefix.pop()

            # Try to make this position greater
            for c in range(ch + 1, 26):

                if freq[c] > 0:

                    ans = prefix.copy()
                    ans.append(chr(c + ord('a')))

                    freq[c] -= 1

                    # Remaining characters sorted
                    for j in range(26):
                        while freq[j] > 0:
                            ans.append(chr(j + ord('a')))
                            freq[j] -= 1

                    return ''.join(ans)

        return ""
        