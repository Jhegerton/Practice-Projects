__author__  = ["Harrison Egerton", "Grok AI"]
__exports__ = ["first_example", "test_diff_epochs"]

# Unpacks imports from the keras library
from keras import Input, Model, datasets
from keras.layers import Flatten, Dense, Dropout

def first_example(epoch_count=5) -> tuple[float, float]:
    """
    This is the first example of a simple model using Keras.
    """
    # Load and preprocess MNIST dataset
    mnist = datasets.mnist #
    (x_train, y_train), (x_test, y_test) = mnist.load_data() # Load data
    x_train, x_test = x_train / 255.0, x_test / 255.0  # Normalize

    # Define model using Functional API with Input(shape)
    inputs = Input(shape=(28, 28))  # Explicit input layer
    x = Flatten()(inputs)  # Flatten the input
    x = Dense(128, activation='relu')(x)  # Dense layer
    x = Dropout(0.2)(x)  # Dropout for regularization
    outputs = Dense(10, activation='softmax')(x)  # Output layer

    # Create model
    model: Model = Model(inputs=inputs, outputs=outputs)

    # Compile
    # Use sparse_categorical_crossentropy for multi-class classification
    model.compile(optimizer='adam',
                  loss='sparse_categorical_crossentropy',
                  metrics=['accuracy'])

    # Train
    model.fit(x_train, y_train, epochs=epoch_count)

    # Evaluate
    res: tuple[float, float] = model.evaluate(x_test, y_test)

    print(res) #

    return res


def test_diff_epochs() -> None:
    """
    Test different number of epochs
    """
    # Execute the trainings and store as dictionary
    attempts : dict[str, float] = {
        "1": first_example(epoch_count=1)[1],
        "2": first_example(epoch_count=3)[1],
        "5": first_example(epoch_count=5)[1],
        "7": first_example(epoch_count=7)[1],
        "9": first_example(epoch_count=9)[1]
    }

    # create a dictionary of the sorted attempts
    # sorted by percentage
    attempts_sorted : dict[str, float] = dict(sorted(attempts.items()))

    # print the results as a rank
    for i, attempt in enumerate(attempts_sorted.items()):
        i: int
        attempt: tuple[str, float]

        # unpack the attempt
        count, percent = attempt
        count: str
        percent: float

        # print the results
        print(f"Rank:{i + 1}, Count:{count} epoch{" " if count == "1" else "s"}, Rate:{percent * 100:.02f}%")
