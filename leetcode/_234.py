class LinkedNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
    
def is_p(head) -> bool:
    if head is None:
        return True
    vals = []
    while head is not None:
        vals.append(head.val)
        head = head.next
    return vals == vals[::-1]

if __name__ == '__main__':
    n1 = LinkedNode(1)
    n2 = LinkedNode(2, n1)
    n3 = LinkedNode(2, n2)
    n4 = LinkedNode(1, n3)
    n5 = LinkedNode(0, n4)
    print('True: ', is_p(n4))
    print('False: ', is_p(n5))