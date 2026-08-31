class Solution:
    def nodesBetweenCriticalPoints(self, head):

        prev = head
        curr = head.next

        index = 1

        first = -1
        last = -1

        min_dist = float('inf')
        max_dist = -1

        while curr.next:

            next_node = curr.next

            # Check if current node is a critical point
            if ((curr.val > prev.val and curr.val > next_node.val) or
                (curr.val < prev.val and curr.val < next_node.val)):

                # First critical point
                if first == -1:
                    first = index

                else:
                    # Distance from previous critical point
                    distance = index - last

                    min_dist = min(min_dist, distance)

                    # Distance from first critical point
                    max_dist = index - first

                last = index

            prev = curr
            curr = next_node
            index += 1

        if min_dist == float('inf'):
            return [-1, -1]

        return [min_dist, max_dist]