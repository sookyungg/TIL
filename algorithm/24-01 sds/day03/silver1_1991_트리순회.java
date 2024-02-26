import java.util.*;
import java.io.*;


class Main {
  
    static int n;
    
    static class TreeNode{
    	char val;
    	TreeNode left;
    	TreeNode right;
    
    	public TreeNode(char val) {
    		this.val=val;
    		this.right=null;
    		this.left=null;
    	}
    }
    //전위순회
    static void preOrder(TreeNode root) {
    	if(root==null) return;
    	System.out.print(root.val);
    	preOrder(root.left);
    	preOrder(root.right);
    }
    
    //중위순회
    static void inOrder(TreeNode root) {
    	if(root==null) return;
    	inOrder(root.left);
    	System.out.print(root.val);
    	inOrder(root.right);
    }
    
    //후위순회
    static void postOrder(TreeNode root) {
    	if(root==null) return;
    	postOrder(root.left);
    	postOrder(root.right);
    	System.out.print(root.val);
    }
    
    static TreeNode[] tree;
    
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
        
    	n=Integer.parseInt(st.nextToken());
    	tree= new TreeNode[n+1];
    	
    	for(int i=0;i<n;i++) {
	    		st=new StringTokenizer(br.readLine());
	    		
	    		char p,l,r;
	    		p=st.nextToken().charAt(0);
	    		l=st.nextToken().charAt(0);
	    		r=st.nextToken().charAt(0);
	    		
	    		if(tree[p-'A']==null) {// 부모 노드가 아직 생성되지 않은 경우
	    			tree[p-'A']=new TreeNode(p);// 부모 노드를 생성
	    		}
	    		
	    		if(l!='.') {// 왼쪽 자식이 존재할 경우
	    			tree[l-'A']=new TreeNode(l);// 왼쪽 자식 노드를 생성
	    			tree[p-'A'].left=tree[l - 'A'];// 부모 노드와 연결
	    		}
	    		
	    		if (r != '.') { // 오른쪽 자식이 존재할 경우
	                tree[r - 'A'] = new TreeNode(r); // 오른쪽 자식 노드를 생성
	                tree[p - 'A'].right = tree[r - 'A']; // 부모 노드와 연결
	            }
    		}
    		//전위
    		preOrder(tree[0]);
    		System.out.println();
    		//증위
    		inOrder(tree[0]);
    		System.out.println();
    		//후위
    		postOrder(tree[0]);
    		System.out.println();
    		
    		
    	}
    }
    
    

