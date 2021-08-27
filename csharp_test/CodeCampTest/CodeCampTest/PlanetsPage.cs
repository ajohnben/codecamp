using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace CodeCampTest
{
    internal class PlanetsPage
    {
        private ChromeDriver driver;

        public PlanetsPage(ChromeDriver driver)
        {
            this.driver = driver;
        }

        internal Planet GetPlanetByName(string planetName)
        {
         
            foreach(var planet in GetPlanets())
            {
                if(planet.Name == planetName)
                {
                    return planet;
                }
            }
            throw new Exception("Could not find planet name");
        }

        private IEnumerable<Planet> GetPlanets()
        {
            var result = new List<Planet>();

            foreach (var planetElement in driver.FindElements(By.ClassName("planet"))) {
                yield return new Planet(planetElement);
            }
        }

        private void ClickUserIcon()
        {
            driver.FindElementByCssSelector(".users").Click();
        }

        public void FillInLoginModalFormThenSubmit()
        {
            ClickUserIcon();

            var loginModalForm = driver.FindElementByCssSelector("#loginDialog");

            var nameField = driver.FindElementByCssSelector("#loginDialog input[type=text]");
            nameField.SendKeys("andy.jones");

            var emailField = driver.FindElementByCssSelector("#loginDialog input[type=password]");
            emailField.SendKeys("abc123");

            GetLoginButton();


        }

        public IEnumerable<IWebElement> GetLoginDialogButtons() => driver.FindElementsByCssSelector("[aria-label=login]");

        public void GetLoginButton()
        {
            foreach(var btn in GetLoginDialogButtons()){
                Console.WriteLine(btn.GetAttribute("[aria-label=login]"));
            }
        }
    }
}