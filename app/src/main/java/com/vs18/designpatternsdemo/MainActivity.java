package com.vs18.designpatternsdemo;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.vs18.designpatternsdemo.builder.Pizza;
import com.vs18.designpatternsdemo.factory_method.*;
import com.vs18.designpatternsdemo.mvc.*;
import com.vs18.designpatternsdemo.observer.*;
import com.vs18.designpatternsdemo.singleton.SettingsManager;
import com.vs18.designpatternsdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.singletonBtn.setOnClickListener(v -> showSingleton());
        binding.factoryBtn.setOnClickListener(v -> showFactory());
        binding.builderBtn.setOnClickListener(v -> showBuilder());
        binding.observerBtn.setOnClickListener(v -> showObserver());
        binding.mvcButton.setOnClickListener(v -> showMVC());
    }

    private void showSingleton() {
        String result = "=== Singleton ===\n\n";
        result += "Один екземпляр класу на весь додаток\n\n";
        result += "Приклад:\n";
        result += SettingsManager.getInstance().getTheme() + "\n";
        result += SettingsManager.getInstance().getLanguage() + "\n";
        result += "Змінимо тему:\n";
        SettingsManager.getInstance().setTheme("Dark");
        result += SettingsManager.getInstance().getTheme();
        binding.resultText.setText(result);
    }

    private void showFactory() {
        String result = "=== Factory Method ===\n\n";
        result += "Створення об'єктів без вказівки точного класу\n\n";
        result += LoggerFactory.createLogger("file").log("Повідомлення в файл") + "\n";
        result += LoggerFactory.createLogger("console").log("Повідомлення в консоль") + "\n";
        result += LoggerFactory.createLogger("network").log("Повідомлення в мережу");
        binding.resultText.setText(result);
    }

    private void showBuilder() {
        String result = "=== Builder ===\n\n";
        result += "Покрокове створення складного об'єкта\n\n";
        Pizza pizza = new Pizza.Builder()
                .size("Велика")
                .dough("Тонке")
                .sauce("Томатний")
                .topping("Сир")
                .topping("Шинка")
                .topping("Гриби")
                .build();
        result += pizza.toString();
        binding.resultText.setText(result);
    }

    private void showObserver() {
        String result = "=== Observer ===\n\n";
        result += "Сповіщення про зміну стану\n\n";

        NewsAgency agency = new NewsAgency();
        NewsChannel channel1 = new NewsChannel("Канал 1");
        NewsChannel channel2 = new NewsChannel("Канал 2");

        agency.addObserver(channel1);
        agency.addObserver(channel2);

        result += "Надсилаємо новину...\n\n";
        agency.setNews("Нова Android 16 вийшла!");

        result += "\nКанали отримали:\n";
        result += channel1.getLatestNews() + "\n";
        result += channel2.getLatestNews();

        binding.resultText.setText(result);
    }

    private void showMVC() {
        String result = "=== MVC (Model-View-Controller) ===\n\n";
        result += "Розділення логіки, даних та UI\n\n";

        Student model = new Student("Іван Петренко", "A+");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();

        result += view.getDisplayText() + "\n\n";

        controller.setStudentGrade("A++");
        controller.updateView();

        result += view.getDisplayText();

        binding.resultText.setText(result);
    }
}