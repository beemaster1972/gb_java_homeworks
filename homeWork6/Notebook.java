// Задание
//
// -Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
// методы. Реализовать в java.
// - Создать множество ноутбуков.
// - Написать метод, который будет запрашивать у пользователя критерий (или критерии)
// фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
// хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// - Далее нужно запросить минимальные значения для указанных критериев - сохранить
// параметры фильтрации можно также в Map.
// - Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
// условиям.

import java.util.Map;
import java.util.Objects;

/** Notebook */
public class Notebook {

  private String manufacturer; // Производитель
  private String model; // Модель ноутбука
  private String typeRAM; // Тип ОЗУ (DDR3 | DDR4 | DDR5)
  private int ramAmount; // Объем ОЗУ
  private String driveType; // Тип накопителя
  private int capacityHDD; // Объем накопителя
  private String typeOS; // Операционка
  private double screenSize; // Диагональ экрана
  private double price; // Цена

  public Notebook(
      String manufacturer,
      String model,
      String typeRAM,
      int ramAmount,
      String driveType,
      int capacityHDD,
      String typeOS,
      double screenSize,
      double price) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.typeRAM = typeRAM;
    this.ramAmount = ramAmount;
    this.driveType = driveType;
    this.capacityHDD = capacityHDD;
    this.typeOS = typeOS;
    this.screenSize = screenSize;
    this.price = price;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public String getModel() {
    return model;
  }

  public String getTypeRAM() {
    return typeRAM;
  }

  public int getRamAmount() {
    return ramAmount;
  }

  public String getDriveType() {
    return driveType;
  }

  public int getCapacityHDD() {
    return capacityHDD;
  }

  public String getTypeOS() {
    return typeOS;
  }

  public double getScreenSize() {
    return screenSize;
  }

  public double getPrice() {
    return price;
  }

  public void setRamAmount(int ramAmount) {
    this.ramAmount = ramAmount;
  }

  public void setDriveType(String driveType) {
    this.driveType = driveType;
  }

  public void setCapacityHDD(int capacityHDD) {
    this.capacityHDD = capacityHDD;
  }

  public void setTypeOS(String typeOS) {
    this.typeOS = typeOS;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean isFiltered(Filter filter){
    Map<Integer, String> mapFilter = filter.getFilter();
    boolean result = true;
    String parameter = "";
    int intParameter = 0;
    if (filter.getFilter().size()==0) return result;
    for (int i=1;i<10;i++){
      if (mapFilter.containsKey(i)){
        parameter = mapFilter.get(i);
        switch (i){
          case 1:
            result = result && this.manufacturer.toLowerCase().equals(parameter.toLowerCase());
            break;
          case 2:
            result = result && this.typeRAM.toLowerCase().equals(parameter.toLowerCase());
            break;
          case 3:
            intParameter = Integer.parseInt(parameter);
            result = result && (this.ramAmount >= intParameter);
            break;
          case 4:
            result = result && this.driveType.toLowerCase().equals(parameter.toLowerCase());
            break;
          case 5:
            intParameter = Integer.parseInt(parameter);
            result = result && (this.capacityHDD >= intParameter);
            break;
          case 6:
            result = result && this.typeOS.toLowerCase().equals(parameter.toLowerCase());
            break;
          case 7:
            double screenDiagonal = Double.parseDouble(parameter);
            result = result && (this.screenSize >= screenDiagonal);
            break;
          default:
            break;
        }

      }
    }
    return result;
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return String.format(
        "Notebook(Производитель: %s, Модель: %s, Тип ОЗУ: %s, Объем ОЗУ: %sГб, Тип накопителя: %s,"
            + " Объем накопителя: %sГБ, Установленная ОС: %s, Диагональ экрана: %s\". Цена: %s"
            + " руб.)",
        manufacturer, model, typeRAM, ramAmount, driveType, capacityHDD, typeOS, screenSize, price);
  }

  @Override
  public int hashCode() {
    // TODO Auto-generated method stub
    return Objects.hash(
        manufacturer, model, typeRAM, ramAmount, driveType, capacityHDD, typeOS, screenSize);
  }

  @Override
  public boolean equals(Object obj) {
    // TODO Auto-generated method stub
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Notebook notebook = (Notebook) obj;
    return ramAmount == notebook.ramAmount
        && capacityHDD == notebook.capacityHDD
        && screenSize == notebook.screenSize
        && Objects.equals(manufacturer, notebook.manufacturer)
        && Objects.equals(model, notebook.model)
        && Objects.equals(typeRAM, notebook.typeRAM)
        && Objects.equals(driveType, notebook.driveType)
        && Objects.equals(typeOS, notebook.typeOS);
  }
}
