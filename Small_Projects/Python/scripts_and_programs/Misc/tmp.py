import numpy as np
import matplotlib.pyplot as plt

# Define x values
x = np.linspace(-10, 10, 400)

# Calculate y values
y = 1 / x

# Plot the graph
plt.figure(figsize=(8, 6))
plt.plot(x, y, label=r'$y = \frac{1}{x}$')
plt.title('Graph of $y = \\frac{1}{x}$')
plt.xlabel('x')
plt.ylabel('y')
plt.axhline(0, color='black',linewidth=0.5)
plt.axvline(0, color='black',linewidth=0.5)
plt.grid(color = 'gray', linestyle = '--', linewidth = 0.5)
plt.xlim(-10, 10)
plt.ylim(-10, 10)
plt.legend()
plt.show()
