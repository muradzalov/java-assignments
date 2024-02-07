public class OrderedKeyValue implements Comparable<OrderedKeyValue> {
  String key;
  int value;

  public OrderedKeyValue(String key, int value) {
      this.key = key;
      this.value = value;
  }

  @Override
  public int compareTo(OrderedKeyValue other) {
      return this.key.compareToIgnoreCase(other.key);
  }
}
