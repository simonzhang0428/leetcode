'''
Your previous Plain Text content is preserved below:

def say_hello():
    print('Hello, World')

for i in range(5):
    say_hello()

 [1,2,2,1]
 
input: singly linked list, always valid, no sanity check
output: bool
example:    


dummy ->  1 -> 2 ->     2 -> 1 -> null
                                f
               s



dummy -> 1 -> 2  null <- 2 <- 1 -> null
                        f     ^
              s               |
                              pre  cur nxt
         
    1 <- 2    2 -> 1
       <-i    j->

dummy ->   1 -> 2 -> 3    2 -> 1 -> null
                               f
                     s
        
    1 -> 2 -> 3  --->    2 -> 1 -> null       odd, second half would be longer
         i               j
         
         
                                        n
                                  c
    1 -> 2 -> 3 -> 2 -> 3 -> 4-> 5   -> null       odd, second half would be longer
              p

            
high level idea:
1. find the middle of the input linked list
2. reverse the second half
3. 2 pointer -> compare

'''
def isP(head):
    dummy = ListNode(0)
    dummy.next = head
    f, s = dummy, dummy
    
    while f and f.next:
        f = f.next.next
        if fast:
            s = s.next
    mid = s
    mid.next = None
    
    if fast:
        
        
    # reverse second part
    pre, cur = None, mid.next
    while cur:
        nxt = cur.next
        cur.next = pre
        pre = cur
        cur = nxt
        