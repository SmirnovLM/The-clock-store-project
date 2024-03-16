package com.example.demo.Logic;


public class Clock_C extends Clock_P {
    protected int Seconds; // Показание секундной стрелки часов

    public Clock_C(String Name, int Cost, int Hours, int Minutes, int Seconds) {
        // Инициализирующий Конструктор для создания объекта 'Часы'
        super(Name, Cost, Hours, Minutes);
        this.Seconds = Seconds;
    }

    public Clock_C(String Name, int Cost, int Hours, int Minutes, int Seconds, int id) {
        // Инициализирующий Конструктор для создания объекта 'Часы' с персональным 'ID'
        super(Name, Cost, Hours, Minutes, id);
        this.Seconds = Seconds;
    }

    // Секция 'Get'
    public int getSeconds() {
        return Seconds;
    }

    public void GetStartTime(TimeType vt, int value) throws ThrowException{
        // Метод Установки Начального Времени для Часов
        if (vt == null)
            throw new ThrowException(value, "The time type is not specified");
        if (value < 0 || value > 59 )
            throw new ThrowException(value, "Value is not corrected");
        if (vt == TimeType.Seconds)
            this.Seconds = value;
        else
            super.GetStartTime(vt, value);
    }

    public void PlusTime(TimeType vt, int value) throws ThrowException{
        // Метод Прибавления Времени для Часов
        if (value < 0)
            throw new ThrowException(value, "The value is nit corrected");
        if (vt == TimeType.Seconds) {
            this.Seconds += value;
            this.Minutes += this.Seconds / 60;
            this.Hours += this.Seconds / 3600;
            this.Seconds %= 60;
        }
        else
            super.PlusTime(vt, value);
    }

    @Override
    public String toString() {
        // Метод Печати Часов
        return  " Name = " + "'" + Name + "'" + "\n" +
                " Cost = " + Cost + "\n" +
                " The value of hours = " + Hours + "\n" +
                " The value of minutes = " + Minutes + "\n" +
                " The value of seconds = " + Seconds + "\n";
    }
}

