package com.epam.pricingcalc.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class DriverUtil {
    private static DriverUtil instance;
    private static ReentrantLock lock = new ReentrantLock(true);
    private static AtomicBoolean isCreated = new AtomicBoolean(false);

    private DriverUtil() {
    }

    public static DriverUtil getInstance() {
        if (instance == null) {
            try {
                lock.lock();
                if (!isCreated.get()) {
                    instance = new DriverUtil();
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public void switchToOtherTabIfExists(WebDriver driver) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String currentWindow = driver.getWindowHandle();
        if (tabs.size() > 1) {
            tabs.remove(currentWindow);
            driver.switchTo().window(tabs.get(0));
        }
    }

    public void createAnotherTab(WebDriver driver) {
        driver.switchTo().newWindow(WindowType.TAB);
    }
}
