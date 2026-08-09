class ListNode{
    int key;
    ListNode next;

    public ListNode(int key){
        this.key = key;
        this.next =null;
    }
}
class MyHashSet {
    ListNode[] set;
    public MyHashSet() {
        set = new ListNode[10000];
        for(int i=0;i<10000;i++){
            set[i]=new ListNode(0); //dummy node
        }

    }

    public void add(int key) {
        ListNode curr = set[hashFunction(key)];
        while(curr.next!=null){
            if(curr.next.key == key) return;
            curr=curr.next;
        }
        curr.next = new ListNode(key);
    }

    public void remove(int key) {
        ListNode curr = set[hashFunction(key)];
        while(curr.next!=null){
            if(curr.next.key==key){
                curr.next=curr.next.next;
                return;

            }
            curr=curr.next;
        }


    }

    public boolean contains(int key) {
        ListNode curr = set[hashFunction(key)];
        while(curr.next!=null){
            if(curr.next.key==key) return true;
            curr=curr.next;
        }
        return false;

    }
    public int hashFunction(int key){
        return key%10000;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */