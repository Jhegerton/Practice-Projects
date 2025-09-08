__author__ = ["Harrison Egerton"]
__export__ = ["WeightCalc"]

from os import linesep as new_line

class WeightCalc:
    """
    class for calculating bmi
    """
    # instance for singleton
    __instance: 'WeightCalc' = None

    @classmethod
    def __new__(cls):
        if not cls.__instance: # if there isn't an instance of this class yet, create one
            cls.__instance = super().__new__(cls)
        return cls.__instance


    @staticmethod
    def _get_my_bmi_label(bmi: float) -> str:
        """
        Returns a string that describes the BMI category based on the given BMI value.
        """
        match bmi:
            case _ if bmi < 18.5:
                return "underweight!"
            case _ if bmi < 24.9:
                return "normal weight."
            case _ if bmi < 30.0:
                return "overweight."
            case _ if bmi < 40.0:
                return "obese!"
            case _:
                return "morbidly obese!"

    @classmethod
    def _get_my_bmi_m(cls) -> None:
        """
        method for getting the BMI in metric units
        """
        height: float = float(input("Enter your height in cm: "))
        weight: float = float(input("Enter your weight in kg: "))
        bmi: float = round(weight / ((height / 100) * (height / 100)), 2)
        print(f"Your BMI is {bmi}. You are {cls._get_my_bmi_label(bmi)}")

    @classmethod
    def _get_my_bmi_imp(cls) -> None:
        """
        method for getting the BMI in imperial units
        """
        height: float = float(input("Enter your height in inches: "))
        weight: float = float(input("Enter your weight in pounds: "))
        bmi = round((weight * 703) / (height * height), 2)
        print(f"Your BMI is {bmi}. You are {cls._get_my_bmi_label(bmi)}")

    @classmethod
    def get_my_bmi(cls) -> None:
        """
        Wrapper method for getting the BMI
        """
        while True:
            try:
                choice = int(input(
                    f"What unit of measurement do you want to use? {new_line}"
                    f"1. Metric{new_line}2. Imperial{new_line}: "
                ))
                if choice == 1:
                    return cls._get_my_bmi_m()
                elif choice == 2:
                    return cls._get_my_bmi_imp()
            except ValueError: # if the user enters an invalid unit of measurement
                print("Invalid input. Please enter either 1 or 2.")


