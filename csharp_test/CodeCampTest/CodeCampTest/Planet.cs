using OpenQA.Selenium;

namespace CodeCampTest
{
    internal class Planet
    {
        private IWebElement planetElement;

        public Planet(IWebElement planetElement)
        {
            this.planetElement = planetElement;
        }

        public string Name => planetElement.FindElement(By.ClassName("name")).Text;

        public double GetRadius()
        {
            var radiusString = planetElement.FindElement(By.ClassName("radius")).Text;

            return double.Parse(radiusString.Replace(" km", ""), System.Globalization.NumberStyles.AllowThousands);
        }

        public IWebElement PlanetElement => planetElement;


    }
}