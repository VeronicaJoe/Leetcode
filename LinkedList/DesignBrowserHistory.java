class BrowserHistory {
    class Node
    {
        String website;
        Node next;
        Node prev;
        
        public Node(String website)
        {
            this.website = website;
        }
        public Node(String website,Node next,Node prev)
        {
            this.website = website;
            this.next = next;
            this.prev = prev;
        }
        
    }
    Node curr = null;
    public BrowserHistory(String homepage) 
    {
        // code here
        curr = new Node(homepage);
    }

    public void visit(String url) 
    {
        // code here
        Node newPage = new Node(url);
        curr.next = newPage;
        newPage.prev = curr;
        curr = newPage;
    }

    public String back(int steps) 
    {
        // code here
        while(steps>0&&curr.prev!=null)
        {
            steps--;
            curr = curr.prev;
        }
        return curr.website;
    }

    public String forward(int steps) {
        // code here
        while(steps>0&&curr.next!=null)
        {
            steps--;
            curr = curr.next;
        }
        return curr.website;
    }
}
