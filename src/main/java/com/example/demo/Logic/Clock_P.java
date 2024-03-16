package com.example.demo.Logic;
// import javax.lang.model.element.Name;
import java.io.Serializable;

public class Clock_P implements InterfaceOfClock, Serializable {
    protected String Name; // Марка часов
    protected int Cost;    // Стоимость часов
    protected int Hours;   // Показание часовой стрелки часов
    protected int Minutes; // Показание минутной стрелки часов

    protected int id = -1; // Персональный 'ID' часов

    public Clock_P(String Name, int Cost, int Hours, int Minutes) {
        // Инициализирующий Конструктор для создания объекта 'Часы'
        this.Name = Name;
        this.Cost = Cost;
        this.Minutes = Minutes;
        this.Hours = Hours;
    }

    public Clock_P(String Name, int Cost, int Hours, int Minutes, int id) {
        // Инициализирующий Конструктор для создания объекта 'Часы' с персональным 'ID'
        this(Name, Cost, Hours, Minutes);
        this.id = id;
    }

    // Секция 'Get'
    public int getId() {
        return id;
    }
    public String getName() {
        return Name;
    }
    public int getCost() {
        return Cost;
    }
    public int getMinutes() {
        return Minutes;
    }
    public int getHours() {
        return Hours;
    }

    public void GetStartTime(TimeType vt, int value) throws ThrowException {
        // Метод Установки Начального Времени для Часов
        if (vt == null)
            throw new ThrowException(value, "The time type is not specified");
        if (value < 0 || value > 59 )
            throw new ThrowException(value, "Value is not corrected");
        else {
            if (value >= 24 && vt == TimeType.Hours)
                throw new ThrowException(value, "Value is not corrected for hours");
            else {
                if (vt == TimeType.Hours)
                    this.Hours = value;
                if (vt == TimeType.Minutes)
                    this.Minutes = value;
            }
        }
    }

    public void PlusTime(TimeType vt, int value) throws ThrowException {
        // Метод Прибавления Времени для Часов
        if (vt == null) {
            throw new ThrowException(value, "The time type is not specified");
        }
        if (value < 0) {
            throw new ThrowException(value, "Value is not corrected");
        }
        if (vt == TimeType.Minutes) {
            this.Minutes += value;
            this.Hours += this.Minutes / 60;
            if (this.Minutes >= 60)
                this.Minutes %= 60;
        }
        if (vt == TimeType.Hours)
            this.Hours += value;
        if (this.Hours >= 24)
            this.Hours %= 24;
    }

    @Override
    public String toString() {
        // Метод Печати Часов
        return  " Name = " + "'" + Name + "'" + "\n" +
                " Cost = " + Cost + "\n" +
                " The value of hours = " + Hours + "\n" +
                " The value of minutes = " + Minutes + "\n";
    }
}


