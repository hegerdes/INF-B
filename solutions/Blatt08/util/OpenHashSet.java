package Blatt08.util;
/**
 * NOTE: Fehler bei HashCode
 * Wenn dieser <0 ist gibt es einen IndexFehler
 */

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Implementation of an open hash set: one bucket holds all entries with the
 * same {@link Object#hashCode()}.
 */
public class OpenHashSet<T> implements HashSet<T>, Serializable {

   static final long serialVersionUID = 11111;
   private transient MyList<T>[] buckets;
   private transient HashFunction<? super T> hashFunction;
   private transient int NumberOfElements;

   /**
    * An <code>OpenHashSet</code> with a hash table of length 10.
    */
   public OpenHashSet() {
      this(10);
   }

   /**
    * An <code>OpenHashSet</code> with a hash table of length <code>size</code>
    *
    * @param size length of the hash table
    */
   public OpenHashSet(int size) {
      this(size, null);
   }

   /**
    * An <code>OpenHashSet</code> with a hash table of length <code>size</code>
    * which uses <code>hashFunction</code> to define the equality of two objects.
    *
    * @param size         length of the hash table
    * @param hashFunction representation of the used hash function
    */
   public OpenHashSet(int size, HashFunction<? super T> hashFunction) {
      this.buckets = new MyList[size];
      NumberOfElements = 0;
      for (int i = 0; i < buckets.length; i++) {
         buckets[i] = new MyList<T>();
      }
      this.hashFunction = hashFunction;
   }


   @Override
   public boolean contains(T o) {
      MyList<T> bucket = buckets[Math.abs(hashCode(o)%buckets.length)];
      bucket.reset();
      while (!bucket.endpos()) {
         if (equals(o, bucket.elem())) {
            return true;
         }
         bucket.advance();
      }
      return false;
   }

   @Override
   public boolean insert(T o) {
      // Eventuell gar keine Null bei insert erlauben
      if (contains(o)) {
         return false;
      } else {
         buckets[Math.abs(hashCode(o)%buckets.length)].add(o);
         NumberOfElements++;
         return true;
      }
   }

   @Override
   public boolean delete(T o) {
      MyList<T> bucket = buckets[Math.abs(hashCode(o) % buckets.length)];
      bucket.reset();
      while (!bucket.endpos()) {
         if (equals(o, bucket.elem())) {
            bucket.delete();
            NumberOfElements--;
            return true;
         }
         bucket.advance();
      }
      return false;
   }

   @Override
   public int hashCode(T o) {
      return hashFunction == null ? o.hashCode() : hashFunction.hashCode(o);
   }

   @Override
   public boolean equals(T o1, T o2) {
      if (hashFunction == null) {
         return o1.equals(o2);
      } else {
         return hashFunction.equals(o1, o2);
      }
   }

   /**
    * Convert all Elements of the HashSet into a String
    * @return String withe all Elements
    */
   public String toString(){
      StringBuilder str = new StringBuilder();

      for(MyList bucket: buckets){
         bucket.reset();
         if(!bucket.empty()) {
            while (!bucket.endpos()) {
               str.append(bucket.elem().toString());
               str.append(" ");
               bucket.advance();
            }
         }
      }
      return str.toString();
   }

   /**
    * Gives the ArraySize of the internal Data structure
    * @return length of buckets
    */
   public int getSize(){
      return buckets.length;
   }

   /**
    * Gives the intern List at the wanted Index
    * @param Index Of the wanted List
    * @return MyList ath the wanted Index
    */
   public MyList<T> getList(int Index){
      return buckets[Index];
   }

   /**
    * Permanent saves a OpenHashSet to a File
    * @param s OutputStream of the Object
    * @throws IOException If Stream fails
    */
   private void writeObject(ObjectOutputStream s) throws IOException {
      s.defaultWriteObject();

      s.writeInt(NumberOfElements);
      s.writeInt(buckets.length);
      s.writeObject(hashFunction);

      for(MyList bucket : buckets){
         if(!bucket.empty()){
            bucket.reset();
            while (!bucket.endpos()){
               s.writeObject(bucket.elem());
               bucket.advance();
            }
         }
      }

   }

   /**
    * Deserialise a OpenHashSet
    * @param s InputStream of a ObjectFile
    * @throws IOException If Inputstream does not mach
    * @throws ClassNotFoundException Can not reconstruct OpenHashSet without OpenHashSet
    */
   @SuppressWarnings("unchecked")
   private void readObject(java.io.ObjectInputStream s)
           throws IOException, ClassNotFoundException {

      s.defaultReadObject();

      int size = s.readInt();
      this.buckets = new MyList[s.readInt()];
      this.hashFunction = (HashFunction<? super T>) s.readObject();

      for(int i = 0;i<buckets.length;i++){
         buckets[i] = new MyList<>();
      }

      for(int i=0; i<size;i++){
         if(!(insert((T) s.readObject()))){
            System.out.println("Fehler bei Insert");
         }
      }


   }


}
