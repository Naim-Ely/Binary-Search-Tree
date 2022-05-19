import java.util.Iterator;
import java.util.Vector;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> 
{
   public void insert(E data) 
   {
	   root = insert(data, root);
   }

   private Node<E> insert(E data, Node<E> node) 
   {
	   if (node == null) 
      {
	      return new Node<E>(data);
      } 
      else 
      {
	      if (data.compareTo(node.data) < 0) 
         {
		      node.left = insert(data, node.left);
	      } 
         else 
         {
		      node.right = insert(data, node.right);
	      }
	   }
	   return node;
   }
   public void remove(E data) 
   { 
      root = remove(root, data); 
   }
   private Node remove(Node<E> node, E data)
   {
      if (node == null)
      {
         return node;
      }
      if (data.compareTo(node.data)<0)
      {
         node.left = remove(node.left, data);
      }
      else if (data.compareTo(node.data)>0)
      {
         node.right = remove(node.right, data);
      }
      else 
      {
         if (node.left == null)
         {
            return node.right;
         }
         else if (node.right == null)
         {
            return node.left;
         }
         node.data = leftValue(node.right);
         node.right = remove(node.right, node.data);
       }
       return node;
   }
   public E leftValue(Node<E> node)
   {
      E minv = node.data;
      while (node.left != null)     
      {
          minv = node.left.data;
          node = node.left;
      }
      return minv;
   }
   public boolean search(E data)
   {
      return search(root, data);
   }
   private boolean search(Node<E> node, E key)
   {
      if (node==null)
      {
         return false;
      }
      if (node.data.compareTo(key)==0)
      {
         return true;
      }
      
      else if (key.compareTo(node.data)>0)
      {
         if (node.right==null)
         {
            return false;
         }
         return search(node.right, key);
      }
      else if (key.compareTo(node.data)<0)
      {
         if (node.left==null)
         {
            return false;
         }
         return search(node.left, key);
      }
      return false;
   }
   public Iterator<E> iterator() 
   {
      vector = new Vector<E>();
      traverse(root);
      return vector.iterator();
   }
   private void traverse(Node<E> curr) 
   {
      if (curr != null) 
      {
         traverse(curr.left);
         vector.add(curr.data);
         traverse(curr.right);
      }
   }
   private Vector<E> vector;
}
