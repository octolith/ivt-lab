package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TorpedoStoreTest {

  private TorpedoStore torpedoStore;

  @BeforeEach
  public void init(){
    this.torpedoStore = new TorpedoStore(10);
  }

  @Test
  public void fire_One_Success(){
    // Arrange

    // Act
    boolean result = torpedoStore.fire(1);

    // Assert
    assertEquals(true, result);
  }

  @Test
  public void fire_Minus_Fail(){
    // Arrange

    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> { torpedoStore.fire(-1); });
  }

  @Test
  public void empty_torpedoStore(){
    // Arrange
    this.torpedoStore = new TorpedoStore(0);

    // Act
    boolean result = torpedoStore.isEmpty();

    // Assert
    assertEquals(true, result);
  }

  @Test
  public void not_empty_torpedoStore(){
    // Arrange
    this.torpedoStore = new TorpedoStore(10);

    // Act
    boolean result = torpedoStore.isEmpty();

    // Assert
    assertEquals(false, result);
  }
  
  @Test
  public void torpedoCount(){
    // Arrange
    this.torpedoStore = new TorpedoStore(10);

    // Act
    int result = torpedoStore.getTorpedoCount();

    // Assert
    assertEquals(10, result);
  }

  @Test
  public void fire_empty_torpedoStore_Fail(){
    // Arrange
    this.torpedoStore = new TorpedoStore(0);

    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> { torpedoStore.fire(1); });
  }
}
